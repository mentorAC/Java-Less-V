World world = new World(30, 50);
world.Generate(750);
while (true)
{
    world.PrintMatrix();
    world.Step();
    Thread.Sleep(200);
    Console.SetCursorPosition(0,0);
}