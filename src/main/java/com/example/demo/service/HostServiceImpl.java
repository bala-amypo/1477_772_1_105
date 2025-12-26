public class HostServiceImpl {

    private HostRepository hostRepository;

    public HostServiceImpl() {}

    public Host createHost(Host h) {
        return hostRepository.save(h);
    }

    public Host getHost(Long id) {
        return hostRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Host not found"));
    }

    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }
}
