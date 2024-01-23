package ru.webwitcher.uni.lab3.furniture;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(Object resource) {
        super("Пользователь не имеет доступа к ресурсу %s. Для начала необходимо занять ресурс.".formatted(
                resource.toString()
        ));
    }
}
