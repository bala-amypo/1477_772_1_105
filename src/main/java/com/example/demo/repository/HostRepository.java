public interface HostRepository {
    Host save(Host h);
    Optional<Host> findById(Long id);
    Optional<Host> findByEmail(String email);
}
