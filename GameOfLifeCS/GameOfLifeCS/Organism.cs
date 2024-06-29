public class Organism
{
    private bool _isLife = false;
    public void kill()
    {
        _isLife = false;
    }
    public void resurrect()
    {
        _isLife = true;

    }
    public void draw()
    {
        if (_isLife == true)
        {
            Console.Write("0");
        }
        else
        {
            Console.Write(" ");
        }
    }

    public bool isLife()
    {
        return _isLife;
    }
}