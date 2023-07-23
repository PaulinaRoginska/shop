package shop.model;

public record Client(String clientName, String clientSurname, String clientAddress) {

    public Client {
        validateClientName(clientName);
        validateClientSurname(clientSurname);
        validateClientAddress(clientAddress);
    }

    private void validateClientName(String clientName) {
        if (clientName == null || !clientName.matches("[a-zA-Z]{1,50}")) {
            throw new IllegalArgumentException("Invalid client name.");
        }
    }

    private void validateClientSurname(String clientSurname) {
        if (clientSurname == null || !clientSurname.matches("[a-zA-Z]{1,50}")) {
            throw new IllegalArgumentException("Invalid client surname.");
        }
    }

    private void validateClientAddress(String clientAddress) {
        if (clientAddress == null || clientAddress.isBlank() || clientAddress.length() == 0 || clientAddress.length() >= 50) {
            throw new IllegalArgumentException("Invalid client address.");
        }
    }
}
