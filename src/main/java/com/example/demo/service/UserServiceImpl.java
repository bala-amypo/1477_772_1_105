public class VisitorServiceImpl {

    private VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Visitor createVisitor(Visitor v) {
        return visitorRepository.save(v);
    }

    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
