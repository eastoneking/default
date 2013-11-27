/*
 * File:b.java Type:eastone.gl.jogl.b
 */
package eastone.gl.jogl;

/**
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-25 下午10:28:59</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A minimal program that draws with JOGL in a Swing JFrame using the AWT
 * GLJPanel.
 * @author Wade Walker
 */
public final class OneTriangleSwingGLJPanel {

  /**
   * .
   */
  private static final int DEFAULT_HEIGHT = 480;
  /**
   * .
   */
  private static final int DEFAULT_LENGTH = 640;

  /**
   * 默认构造函数.
   */
  private OneTriangleSwingGLJPanel() {
  }

  /**
   * 主函数.
   * @param args 参数。
   */
  public static void main(final String[] args) {
    GLProfile glprofile = GLProfile.getDefault();
    GLCapabilities glcapabilities = new GLCapabilities(glprofile);
    GLJPanel gljpanel = new GLJPanel(glcapabilities);

    gljpanel.addGLEventListener(new GLEventListener() {

      @Override
      public void reshape(
          final GLAutoDrawable glautodrawable, final int x, final int y,
          final int width, final int height) {
        OneTriangle.setup(glautodrawable.getGL().getGL2(), width, height);
      }

      @Override
      public void init(final GLAutoDrawable glautodrawable) {
      }

      @Override
      public void dispose(final GLAutoDrawable glautodrawable) {
      }

      @Override
      public void display(final GLAutoDrawable glautodrawable) {
        OneTriangle.render(glautodrawable.getGL().getGL2(),
            glautodrawable.getWidth(), glautodrawable.getHeight());
      }
    });

    final JFrame jframe = new JFrame("One Triangle Swing GLJPanel");
    jframe.addWindowListener(new WindowAdapter() {
      public void windowClosing(final WindowEvent windowevent) {
        jframe.dispose();
        System.exit(0);
      }
    });

    jframe.getContentPane().add(gljpanel, BorderLayout.CENTER);
    jframe.setSize(DEFAULT_LENGTH, DEFAULT_HEIGHT);
    jframe.setVisible(true);
  }
}
