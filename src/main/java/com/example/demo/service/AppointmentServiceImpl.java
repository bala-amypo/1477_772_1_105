public Appointment createAppointment(Long visitorId, Long hostId, Appointment ap) {

    if (ap.getAppointmentDate().isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("appointmentDate cannot be past");
    }

    Visitor v = visitorRepository.findById(visitorId)
        .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

    Host h = hostRepository.findById(hostId)
        .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

    ap.setVisitor(v);
    ap.setHost(h);
    ap.setStatus("SCHEDULED");

    return appointmentRepository.save(ap);
}
