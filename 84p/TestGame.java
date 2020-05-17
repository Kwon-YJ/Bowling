public class TestGame {
    private TestGame g;
    public void setup(){
        g = new TestGame();
    }
    public static void main(String[] args){
        TestGame tg = new TestGame();
        tg.testTwoThrowsNoMark();
        tg.testFourThrowsNoMark();
        tg.testSimpleSpare();
        tg.testSimpleFrameAfterSpare();
        tg.testSimpleStrike();
        tg.testPerfectGame();
        tg.testSampleGame();
        tg.testHeartBreak();
        tg.testTenthFrameSpare();
    }
    public void assertEquals(int first, int second){
        if (first == second){
            System.out.println("");
        }
        else{
            System.out.println("ERROR");
            System.out.println(first);
            System.out.println(second);
        }
    }
    public void testTwoThrowsNoMark(){
        Game g = new Game();
        g.add(5);
        g.add(4);
        assertEquals(9, g.score());
    }
    public void testFourThrowsNoMark(){
        Game g = new Game();
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.score());
        assertEquals(9, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
    }
    public void testSimpleSpare(){
        Game g = new Game();
        g.add(3);
        g.add(7);
        g.add(3);
        assertEquals(13, g.scoreForFrame(1));
    }
    public void testSimpleFrameAfterSpare(){
        Game g = new Game();
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
        assertEquals(18, g.score());
        assertEquals(3, g.getCurrentFrame());
    }
    public void testSimpleStrike(){
        Game g = new Game();
        g.add(10);
        g.add(3);
        g.add(6);
        assertEquals(19, g.scoreForFrame(1));
        assertEquals(28, g.score());
        assertEquals(3, g.getCurrentFrame());
    }
    public  void testPerfectGame(){
        Game g = new Game();
        for (int i = 0; i < 12; i++){
            g.add(10);
        }
        assertEquals(300, g.score());
        assertEquals(11, g.getCurrentFrame());
    }

    public void testSampleGame(){
        Game g = new Game();
        g.add(1);
        g.add(4);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(4);
        g.add(5);
        g.add(5);
        g.add(10);
        g.add(0);
        g.add(1);
        g.add(7);
        g.add(3);
        g.add(6);
        g.add(4);
        g.add(10);
        g.add(2);
        g.add(8);
        g.add(6);
        assertEquals(133, g.score());
    }
    public void testHeartBreak(){
        Game g = new Game();
        for (int i = 0; i < 11; i++)
            g.add(10);
        g.add(9);
        assertEquals(299, g.score());
    }
    public void testTenthFrameSpare(){
        Game g = new Game();
        for(int i = 0; i < 9; i++){
            g.add(10);
        }
        g.add(9);
        g.add(1);
        g.add(1);
        assertEquals(270, g.score());
    }
}
