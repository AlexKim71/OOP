package ua.opnu;

public abstract class GameShape {
    public abstract String getName();
}

class Rock extends GameShape {
    @Override
    public String getName() { return "Камінь"; }
}

class Scissors extends GameShape {
    @Override
    public String getName() { return "Ножиці"; }
}

class Paper extends GameShape {
    @Override
    public String getName() { return "Папір"; }
}
