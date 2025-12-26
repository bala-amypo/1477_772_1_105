public AlertNotification sendAlert(Long visitLogId) {

    VisitLog vl = visitLogRepository.findById(visitLogId)
        .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

    if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
        throw new IllegalArgumentException("Alert already sent");
    }

    AlertNotification alert = new AlertNotification();
    alert.setVisitLog(vl);
    alert.setSentTo(vl.getHost().getEmail());
    alert.setSentAt(LocalDateTime.now());

    vl.setAlertSent(true);
    visitLogRepository.save(vl);

    return alertRepository.save(alert);
}
