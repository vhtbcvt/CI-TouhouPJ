package touhou.bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0,0);
    }

    public Vector2D(float x, float y){
        this.x= x;
        this.y= y;
    }

    public void addUp(float dx,float dy){
        this.x += dx;
        this.y += dy;
    }

    public void addUp(Vector2D other){
        addUp(other.x, other.y);
    }

    public void subtractBy(float dx, float dy){
        this.x -= dx;
        this.y -= dy;
    }

    public void subtractBy(Vector2D other){
        subtractBy(other.x, other.y);
    }

    public Vector2D add(float dx, float dy){
        return new Vector2D(this.x + dx, this.y +dy);
    }

    public Vector2D add(Vector2D other){
        return add( other.x, other.y );
    }

    public Vector2D subtract(float dx, float dy){
        return new Vector2D(this.x - dx, this.y - dy);
    }

    public Vector2D subtract(Vector2D other){
        return subtract(other.x, other.y);
    }

    public Vector2D multiply(float f){
        return new Vector2D(this.x * f, this.y * f);
    }

    public float length() //*magnitude
    {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2D normalize(){
        float mag = length();
        return new Vector2D(this.x / mag, this.y / mag);
    }
}
