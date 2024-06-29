
public class World
{
    private Organism[,] matrix;
    private Organism[,] matrixtwo;
    public World(int rows, int cols)
    {
        matrix = new Organism[rows, cols];
        matrixtwo = new Organism[rows, cols];


        for (int i = 0; i < matrix.GetLength(0); i++)
        {
            for (int j = 0; j < matrix.GetLength(1); j++)
            {
                matrix[i, j] = new Organism();
                matrixtwo[i, j] = new Organism();
            }
        }
    }
    public void PrintMatrix()
    {
        for (int i = 0; i < matrix.GetLength(1) + 2; i++)
        {
            Console.Write("-");
        }
        Console.WriteLine();
        for (int i = 0; i < matrix.GetLength(0); i++)
        {
            Console.Write("|");
            for (int j = 0; j < matrix.GetLength(1); j++)
            {
                matrix[i, j].draw();


            }
            Console.Write("|");
            Console.WriteLine();
        }
        for (int i = 0; i < matrix.GetLength(1) + 2; i++)
        {
            Console.Write("-");
        }
        Console.WriteLine();
    }
    public void Generate(int count)
    {
        for (int i = 0; i < count; i++)
        {
            Random random = new Random();
            int y, x;
            do
            {
                y = random.Next(matrix.GetLength(0));
                x = random.Next(matrix.GetLength(1));
            } while (matrix[y, x].isLife());
            matrix[y, x].resurrect();
        }
    }
    public void Step()
    {
        for (int i = 0; i < matrixtwo.GetLength(0); i++)
        {
            for (int j = 0; j < matrixtwo.GetLength(1); j++)
            {
                matrixtwo[i, j].kill();
            }
        }
        for (int i = 0; i < matrix.GetLength(0); i++)
        {
            for (int j = 0; j < matrix.GetLength(1); j++)
            {
                int count = Neighbour(i, j);
                if (count < 2 || count > 3)
                {
                    matrixtwo[i, j].kill();
                }
                if (count == 3)
                {
                    matrixtwo[i, j].resurrect();
                }
                if ((count == 2 || count == 3) && matrix[i, j].isLife())
                {
                    matrixtwo[i, j].resurrect();
                }
            }


        }
        (matrix, matrixtwo) = (matrixtwo, matrix);
    }
    private int Neighbour(int i, int j)
    {
        int[] biasI = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] biasJ = { -1, 0, 1, 1, 1, 0, -1, -1 };
        int count = 0;
        for (int k = 0; k < biasI.Length; k++)
        {
            int i_ = i + biasI[k];
            int j_ = j + biasJ[k];
            if (inBoard(i_, j_) && matrix[i_, j_].isLife())
            {
                count++;
            }

        }
        return count;

    }
    private bool inBoard(int i, int j)
    {
        return i >= 0 && j >= 0 && i < matrix.GetLength(0) && j < matrix.GetLength(1);
    }

}
