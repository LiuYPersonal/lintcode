package solution497;

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    // Write your code here
    public void draw(){
    	System.out.println(" ---- \n|    |\n|    |\n ---- ");
    }
    
}

class Square implements Shape {
    // Write your code here
    public void draw(){
    	System.out.println("  /\\   \n  /  \\  \n/____\\");
    }
}

class Triangle implements Shape {
    // Write your code here
    public void draw(){
    	System.out.println(" ---- \n|    |\n ----");
    }
}

public class ShapeFactory {
    /**
     * @param shapeType a string
     * @return Get object of type Shape
     */
    public Shape getShape(String shapeType) {
        // Write your code here
        if(shapeType=="Square"){
        	return new Square();
        }
        else if(shapeType=="Triangle"){
            return new Triangle();
        }
        else{
            return new Rectangle();
        }
    }
}