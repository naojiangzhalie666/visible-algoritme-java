import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private FractalData data;        // 数据 model
    private AlgoFrameTrangle frame;    // 视图 view

    public AlgoVisualizer(int maxDepth) {

        data = new FractalData(maxDepth);
        int sceneWidth = (int) (Math.pow(2, maxDepth));
        int sceneHeight = (int) (Math.pow(2, maxDepth));

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrameTrangle("Sierpink Visualizer", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());

            // TODO: 根据情况决定是否加入键盘鼠标事件监听器

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run() {

        // TODO: 编写自己的动画逻辑
        setData(4);
    }

    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyChar() >= '0' && e.getKeyChar() <='9'){
                int depth = e.getKeyChar() - '0';
                setData(depth);
            }
        }
    }

    private void setData(int depth) {
        if (depth >= 0)
            data.depth = depth;
        frame.render(data);
        AlgoVisHelper.pause(40);
    }


    public static void main(String[] args) {

        int maxDepth = 9;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(maxDepth);
    }
}
