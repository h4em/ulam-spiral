import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    private boolean[] primes = sieveOfEratosthenes();
    private final int primeBound = 1080 * 10 * 1080 * 10;
    public Main() {
        setTitle("Ulam spiral");
        setSize(new Dimension(640, 640));
        setMinimumSize(new Dimension(640, 640));
        setMaximumSize(new Dimension(1920, 1080));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentListener( new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }
        });

        centerOnScreen();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(102, 0, 255, 255));

        int x = getWidth() / 2;
        int y = getHeight() / 2;

        int i_px = 1;
        int side = 3;

        while(x <= getWidth() || y <= getHeight()) {
            x++;
            i_px++;

            //right 1
            if(primes[i_px])
                g.drawLine(x, y, x, y);

            //up
            for(int i = 0; i < side - 2; i++) {
                y--;
                i_px++;
                if(primes[i_px])
                    g.drawLine(x, y, x, y);
            }

            //left
            for(int i = 0; i < side - 1; i++) {
                x--;
                i_px++;
                if(primes[i_px])
                    g.drawLine(x, y, x, y);
            }

            //down
            for(int i = 0; i < side - 1; i++) {
                y++;
                i_px++;
                if(primes[i_px])
                    g.drawLine(x, y, x, y);
            }

            //right
            for(int i = 0; i < side - 1; i++) {
                x++;
                i_px++;
                if(primes[i_px])
                    g.drawLine(x, y, x, y);
            }
            side += 2;
        }
    }

    private boolean[] sieveOfEratosthenes() {
        boolean[] primes = new boolean[primeBound + 1];
        for(int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        for(int p = 2; p * p < primes.length; p++) {
            if(primes[p] == true) {
                for(int i = p * p; i < primes.length; i += p) {
                    primes[i] = false;
                }
            }
        }

        return primes;
    }

    private void centerOnScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        setLocation(centerX, centerY - 30);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}