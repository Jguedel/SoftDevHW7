
/*
 * @author jguedel
 * @version 1.0
 * 
 */
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends Composite {

	/** The File. */
	private Text File;

	/** The Ans. */
	private Text Ans;

	/** The selected file. */
	private File selectedFile;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));
		Main Key = new Main(shell, SWT.NONE);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();

		}
		display.dispose();
	}

	/**
	 * Create the composite.
	 *
	 * @param parent the parent
	 * @param style  the style
	 */
	public Main(Composite parent, int style) {
		super(parent, style);
		setLayout(null);

		Label lblKeyWordsIn = new Label(this, SWT.NONE);
		lblKeyWordsIn.setFont(SWTResourceManager.getFont("Segoe UI", 22, SWT.BOLD));
		lblKeyWordsIn.setBounds(0, 0, 235, 39);
		lblKeyWordsIn.setText("Key words in FIle");

		File = new Text(this, SWT.BORDER);
		File.setEnabled(false);
		File.setEditable(false);
		File.setTouchEnabled(true);
		File.setText("File Name to be Searched");
		File.setBounds(0, 59, 235, 19);

		Button SeachFile = new Button(this, SWT.NONE);
		SeachFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				try {
					HashT.Hash(selectedFile);
					String ans = HashT.getH().toString();
					Ans.setText(HashT.getDescription() + "\nTotal lines of code: " + HashT.getLOC()
							+ "\nTotal time in milliseconds: " + HashT.getTime() + "\n" + ans);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		SeachFile.setBounds(165, 84, 70, 21);
		SeachFile.setText("Seach File");

		Ans = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		Ans.setTouchEnabled(true);
		Ans.setEditable(false);
		Ans.setBounds(0, 111, 235, 90);

		Button FindFile = new Button(this, SWT.NONE);
		FindFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = jfc.getSelectedFile();
					File.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		FindFile.setBounds(0, 84, 70, 21);
		FindFile.setText("Find File");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.widgets.Composite#checkSubclass()
	 */
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
