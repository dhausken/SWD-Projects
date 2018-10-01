

public class ShapeInheritanceTest
{
    public static void main(String args[])
    {
        Shapes shape = new Shapes("Generic Shape","Red",true);
        TwoDimensional twoDimensional = new TwoDimensional("Generic 2D Shape", "Blue", true);
        ThreeDimensional threeDimensional = new ThreeDimensional("Generic 3D Shape", "Yellow",false);
        Rectangular2DShapes rectangular2DShapes = new Rectangular2DShapes("Generic 2D rectangular shape","Green",false,10,5);
        Rectangular3DShapes rectangular3DShapes = new Rectangular3DShapes("Generic 3D rectangular shape","Orange",false,5,3,2);
        Triangular3DShapes triangular3DShapes = new Triangular3DShapes("Generic 3D triangular shape","Black",true,9,4);
        Triangular2DShapes triangular2DShapes = new Triangular2DShapes("Generic 2D triangular shapes","White",true,12,3);
        Circular3DShapes circular3DShapes = new Circular3DShapes("Generic 3D circle","Red",false,15);
        Circular2DShapes circular2DShapes = new Circular2DShapes("Generic 2D circle","Blue",false,10);
        Circle circle = new Circle("Generic circle","Yellow",true,5);
        Cone cone = new Cone("Party Hat","Polka Dot",true,7,8);
        Cube cube = new Cube("Box","Brown",true,10,10,10);
        Oval oval = new Oval("Face","Peach",true,10,4);
        Rectangle rectangle = new Rectangle("Table","Blue",true,10,5);
        RectangularPrism rectangularPrism = new RectangularPrism("Table","Brown",true, 10,5,6);
        RightTriangle rightTriangle = new RightTriangle("Generic right triangle","Purple",true,3,4);
        Sphere sphere = new Sphere("Ball","Red",true,8);
        Square square = new Square("Tile","Checkers",true,5,5);
        TriangularPrism triangularPrism = new TriangularPrism("Prism","Clear",true,10,10,6,6,6);
    }
}
