package gui;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("serial")
public class ArvoreArquivos extends JTree {
	private ArvoreArquivos(DefaultTreeModel treeModel) {
		super(treeModel);
	}
	
	public static ArvoreArquivos Inicializar(String caminhoDiretorio, String tituloRoot) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(tituloRoot);
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        addChilds(root, caminhoDiretorio);
        
        ArvoreArquivos arvore = new ArvoreArquivos(treeModel);
        
        return arvore;
	}
	
	private static void addChilds(DefaultMutableTreeNode rootNode, String path) {
        File[] files = getListFiles(path);
        
        for (File file : files) {
            if (file.isDirectory()) {
                DefaultMutableTreeNode subDirectory = new DefaultMutableTreeNode(file.getName());
                addChilds(subDirectory, file.getAbsolutePath());
                rootNode.add(subDirectory);
            } else {
                rootNode.add(new DefaultMutableTreeNode(file.getName()));
            }
        }
    }
	
	private static File[] getListFiles(String Path) {
        File file = new File(Path);
        return file.listFiles();
    }
}
