public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {

    Visitor v = visitorRepository.findById(visitorId)
        .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

    Host h = hostRepository.findById(hostId)
        .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

    VisitLog vl = new VisitLog();
    vl.setVisitor(v);
    vl.setHost(h);
    vl.setPurpose(purpose);
    vl.setCheckInTime(LocalDateTime.now());
    vl.setAccessGranted(true);
    vl.setAlertSent(false);

    return visitLogRepository.save(vl);
}

public VisitLog checkOutVisitor(Long id) {

    VisitLog vl = visitLogRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

    if (vl.getCheckInTime() == null) {
        throw new IllegalStateException("Visitor not checked in");
    }

    vl.setCheckOutTime(LocalDateTime.now());
    return visitLogRepository.save(vl);
}
