public class Ladder {
    private final int width;
    private final int height;
    private boolean[][] shape;

    public Ladder(int width, int height) {
        if(width < 1 || height < 1)
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다.");
        this.width = width;
        this.height = height;
    }

    public boolean[][] getShape() {
        return shape;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setShape(boolean[][] shape) {
        this.shape = shape;
    }

    private String getRowShape(int row){
        StringBuilder stringBuilder = new StringBuilder();
        for(int c = 0 ; c < shape[row].length-1; ++c){
            stringBuilder.append(getMaterial(shape[row][c]));
        }
        stringBuilder.append("|\n");
        return stringBuilder.toString();
    }
    private String getMaterial(boolean bridge){
        return bridge? "|-" : "| ";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int r = 0 ; r < shape.length; ++r){
            stringBuilder.append(getRowShape(r));
        }
        return stringBuilder.toString();
    }

}