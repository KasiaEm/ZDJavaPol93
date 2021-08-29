package sda.ex.ex16;

public interface Measurable {
    Double area();

    default String show() {
        return "Not labelled yet.";
    }
}
