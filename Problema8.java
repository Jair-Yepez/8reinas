





package problema8;

import javax.swing.*;
import java.awt.*;

public class Problema8 extends JPanel {
    final int N = 8;
    int[] reinas = new int[N + 1]; 
    boolean solucion = false; 
    JFrame frame;

    public Problema8() {
        frame = new JFrame("Problema de las 8 Reinas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(this);
        frame.setVisible(true);
    }

    public boolean solucionReinas() {
        ponerReina(1); 
        return solucion;
    }

    private void ponerReina(int i) {
        for (int j = 1; j <= N; j++) { 
            reinas[i] = j; 
            if (valido(i)) {
                if (i < N) { 
                    ponerReina(i + 1); 
                    
                    if (solucion) {
                        return;
                    }
                } else { 
                    solucion = true; 
                    repaint();  
                    return; 
                }
            }
        }
    }

    private boolean valido(int i) {
        for (int r = 1; r < i; r++) { 
            if (reinas[i] == reinas[r] ||
                (i + reinas[i] == r + reinas[r]) || 
                (i - reinas[i] == r - reinas[r])) { 
                return false; 
            }
        }
        return true; 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tileSize = getWidth() / N; 

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.black);
                }
                g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
            }
        }

       
        g.setColor(Color.BLUE);
        for (int i = 1; i <= N; i++) {
            int x = (i - 1) * tileSize;
            int y = (reinas[i] - 1) * tileSize;
            g.fillOval(x + tileSize / 4, y + tileSize / 4, tileSize / 2, tileSize / 2);
        }
    }

    public static void main(String[] args) {
        Problema8 juego = new Problema8();
        juego.solucionReinas();
    }
}
  



