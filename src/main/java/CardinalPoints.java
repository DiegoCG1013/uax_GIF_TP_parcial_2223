public enum CardinalPoints {
    NORTH(-1),
    SOUTH(1),
    EAST(1),
    WEST(-1);
    private int movimiento;

    CardinalPoints(int i) {
        this.movimiento = i;
    }

    public int getMovimiento() {
        return movimiento;
    }
}
