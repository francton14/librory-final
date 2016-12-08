/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcl.librory.gui;

import com.tcl.librory.database.dao.BookDao;
import com.tcl.librory.database.dao.LibrarianDao;
import com.tcl.librory.database.dao.impl.BookDaoImpl;
import com.tcl.librory.database.dao.impl.LibrarianDaoImpl;
import com.tcl.librory.models.Book;
import com.tcl.librory.models.Genre;
import com.tcl.librory.models.Librarian;
import com.tcl.librory.sessionmanagement.Session;
import com.tcl.librory.utils.DateUtils;
import java.awt.CardLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/**
 *
 * @author franc.margallo
 */
public class Librory extends javax.swing.JFrame {

    private Session session;
    private CardLayout cardLayout;
    private LibrarianDao librarianDao;
    private BookDao bookDao;
    /**
     * Creates new form Librarian
     */
    public Librory() {
	initComponents();
	cardLayout = (CardLayout) this.getContentPane().getLayout();
	try {
	    session = new Session();
	    getAuthenticated();
            librarianDao = new LibrarianDaoImpl();
	    bookDao = new BookDaoImpl();
	} catch (IOException | InstantiationException | SQLException | IllegalAccessException ex) {
	    Logger.getLogger(Librory.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    private void getAuthenticated() {
	try {
	    if (session.getUserID() != null) {
		authorized();
	    } else {
		unAuthorized();	
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(Librory.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    private void authorized()
    {
	cardLayout.show(this.getContentPane(), "cardLibrarian");
	setJMenuBar(librarianMenu);
    }
    
    private void unAuthorized()
    {
	cardLayout.show(this.getContentPane(), "cardUnauth");
	setJMenuBar(unauthMenu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        unauthMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuUnauthSignin = new javax.swing.JMenuItem();
        mnuUnauthExit = new javax.swing.JMenuItem();
        pnlUnauth = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtUnauthSearch = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnUnauthSearch = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUnauthBooks = new javax.swing.JTable();
        pnlLibrarian = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtLibSearch = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnLibSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibBooks = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnLibLend = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnLibUpdate = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnLibDelete = new javax.swing.JButton();
        librarianMenu = new javax.swing.JMenuBar();
        menuAccount = new javax.swing.JMenu();
        mnuLibProfile = new javax.swing.JMenuItem();
        mnuLibLogout = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuLibExit = new javax.swing.JMenuItem();
        menuBooks = new javax.swing.JMenu();
        mnuLibAdd = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuLibBorrowed = new javax.swing.JMenuItem();

        jMenu1.setText("Librory");

        mnuUnauthSignin.setText("Sign in");
        jMenu1.add(mnuUnauthSignin);

        mnuUnauthExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnuUnauthExit.setText("Exit");
        jMenu1.add(mnuUnauthExit);

        unauthMenu.add(jMenu1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        pnlUnauth.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        txtUnauthSearch.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        jPanel3.add(txtUnauthSearch);
        jPanel3.add(filler1);

        btnUnauthSearch.setText("Search");
        jPanel3.add(btnUnauthSearch);

        pnlUnauth.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setLayout(new java.awt.BorderLayout());

        tblUnauthBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Author", "Publisher", "Date Published"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblUnauthBooks);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlUnauth.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlUnauth, "cardUnauth");

        pnlLibrarian.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        txtLibSearch.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        jPanel1.add(txtLibSearch);
        jPanel1.add(filler2);

        btnLibSearch.setText("Search");
        jPanel1.add(btnLibSearch);

        pnlLibrarian.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.setLayout(new java.awt.BorderLayout());

        tblLibBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Publisher", "Published Date", "Is Available?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLibBooks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblLibBooks);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        btnLibLend.setText("Lend...");
        btnLibLend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibLendActionPerformed(evt);
            }
        });
        jPanel5.add(btnLibLend);
        jPanel5.add(filler3);

        btnLibUpdate.setText("Update");
        jPanel5.add(btnLibUpdate);
        jPanel5.add(filler4);

        btnLibDelete.setText("Delete");
        jPanel5.add(btnLibDelete);

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        pnlLibrarian.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlLibrarian, "cardLibrarian");

        menuAccount.setText("Account");

        mnuLibProfile.setText("Profile");
        menuAccount.add(mnuLibProfile);

        mnuLibLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        mnuLibLogout.setText("Logout");
        menuAccount.add(mnuLibLogout);
        menuAccount.add(jSeparator2);

        mnuLibExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnuLibExit.setText("Exit");
        menuAccount.add(mnuLibExit);

        librarianMenu.add(menuAccount);

        menuBooks.setText("Books");

        mnuLibAdd.setText("Add...");
        mnuLibAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLibAddActionPerformed(evt);
            }
        });
        menuBooks.add(mnuLibAdd);
        menuBooks.add(jSeparator1);

        mnuLibBorrowed.setText("Borrowed Books");
        menuBooks.add(mnuLibBorrowed);

        librarianMenu.add(menuBooks);

        setJMenuBar(librarianMenu);

        setSize(new java.awt.Dimension(690, 531));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLibLendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibLendActionPerformed
	
    }//GEN-LAST:event_btnLibLendActionPerformed

    private void mnuLibAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLibAddActionPerformed
	JTextField txtControlNumber = new JTextField();
        JTextField txtIsbn = new JTextField();
        JTextField txtTitle = new JTextField();
        JTextField txtAuthor = new JTextField();
        JTextField txtPublisher = new JTextField();
        JFormattedTextField txtDatePublished = new JFormattedTextField(new SimpleDateFormat("MM-dd-yyyy"));
        JComboBox<Genre> cbxGenre = new JComboBox<>(Genre.values());
        Object[] fields = {"Control Number", txtControlNumber, 
            "ISBN", txtIsbn, "Title", txtTitle, "Author", txtAuthor, 
            "Publisher", txtPublisher, "Date Published", txtDatePublished, 
            "Genre", cbxGenre};
        if (JOptionPane.showConfirmDialog(this, fields, "Librory - Add New Book", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                String controlNumber = txtControlNumber.getText().trim();
                String isbn = txtIsbn.getText().trim();
                String title = txtTitle.getText().trim();
                String author = txtAuthor.getText().trim();
                String publisher = txtPublisher.getText().trim();
                Date datePublished = DateUtils.toDate(txtDatePublished.getText());
                Genre genre = (Genre) cbxGenre.getSelectedItem();
                Book book = new Book();
                book.setControlNumber(Long.valueOf(controlNumber));
                book.setIsbn(isbn);
                book.setTitle(title);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setPublishedDate(datePublished);
                book.setGenre(genre);
                book.setLibrarian(authenticated());
                bookDao.insert(book);
            } catch (ParseException | SQLException ex) {
                Logger.getLogger(Librory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }//GEN-LAST:event_mnuLibAddActionPerformed

    private Librarian authenticated() {
        try {
            return librarianDao.show(session.getUserID());
        } catch (SQLException ex) {
            Logger.getLogger(Librory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLibDelete;
    private javax.swing.JButton btnLibLend;
    private javax.swing.JButton btnLibSearch;
    private javax.swing.JButton btnLibUpdate;
    private javax.swing.JButton btnUnauthSearch;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar librarianMenu;
    private javax.swing.JMenu menuAccount;
    private javax.swing.JMenu menuBooks;
    private javax.swing.JMenuItem mnuLibAdd;
    private javax.swing.JMenuItem mnuLibBorrowed;
    private javax.swing.JMenuItem mnuLibExit;
    private javax.swing.JMenuItem mnuLibLogout;
    private javax.swing.JMenuItem mnuLibProfile;
    private javax.swing.JMenuItem mnuUnauthExit;
    private javax.swing.JMenuItem mnuUnauthSignin;
    private javax.swing.JPanel pnlLibrarian;
    private javax.swing.JPanel pnlUnauth;
    private javax.swing.JTable tblLibBooks;
    private javax.swing.JTable tblUnauthBooks;
    private javax.swing.JTextField txtLibSearch;
    private javax.swing.JTextField txtUnauthSearch;
    private javax.swing.JMenuBar unauthMenu;
    // End of variables declaration//GEN-END:variables
}
