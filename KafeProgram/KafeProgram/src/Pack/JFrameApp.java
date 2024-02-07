package Pack;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Glavna klasa koja predstavlja aplikaciju
public class JFrameApp extends JFrame {
    private int width = 800;
    private int height = 600;

    //polja za panele
    private JPanel parent;
    private JPanel panel1;
    private JPanel panel2a;
    private JPanel panel2b;
    private JPanel panel2c;
    private JPanel panel3;
    private JLabel title;
    private JPanel buttons;

    //polja za 3 vrste proizvoda
    private JRadioButton product1;
    private JRadioButton product2;
    private JRadioButton product3;
    private ButtonGroup productgroup;

 // Ostala polja za interfejs
    private JPanel subpanel1;
    private JPanel subpanel2;
    private JPanel subpanel3;
    private JPanel subpanel4;
    private JPanel subpanel5;

    private JTextArea text;

    private JScrollPane scroll;

    private BorderLayout layout;

    private JButton button1;
    private JButton button2;
    private JButton button3;

    private String[] kafaNiz = {"Espresso", "Espresso sa mlekom", "Cappucino", "Domaca kafa", "Nescafe"};
    private JList<String> listaKafa;
    private int[] indeksKafa = {};

    private String[] gaziraniNiz = {"Coca cola", "Fanta", "Sprite", "Shweppes"};
    private JList<String> listaGazirani;
    private int[] indeksGazirani = {};

    private String[] negaziraniNiz = {"Next sokovi", "Cedevita"};
    private JList<String> listaNegazirani;
    private int[] indeksNegazirani = {};

    private JLabel quantitylabel;
    private JTextField quantity;
    private JRadioButton membery;
    private JRadioButton membern;
    private ButtonGroup membergroup;
    private JButton delete;

 // Ostala polja za proizvode...
    private boolean isMember;

    private Narudzbina trenutnaNarudzbina;
    private Kafa kafa;
    private GaziraniSok gazSok;
    private NegaziraniSok negSok;

 // Konstruktor koji postavlja osnovne parametre prozora i inicijalizuje komponente
    public JFrameApp() {
    	// Postavljanje osnovnih parametara prozora
        setTitle("Aplikacija");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.LIGHT_GRAY);

     // Kreiranje interfejsa
        buildPanel();
     // Dodavanje komponenti na prozor
        add(panel3, BorderLayout.CENTER);
        add(title, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
        add(parent, BorderLayout.WEST);

        setVisible(true);

     // Inicijalizacija objekata
        trenutnaNarudzbina = new Narudzbina();
        kafa = new Kafa(kafaNiz);
        gazSok = new GaziraniSok(gaziraniNiz);
        negSok = new NegaziraniSok(negaziraniNiz);
    }

 // Metoda za kreiranje panela i komponenti interfejsa	
    private void buildPanel() {
    	
    	// Kreiranje panela i postavljanje rasporeda
        parent = new JPanel();
        parent.setLayout(new BorderLayout(10, 10));

        title = new JLabel("Racun");
        title.setHorizontalAlignment(SwingConstants.CENTER);

        panel1 = new JPanel();
        panel2a = new JPanel();
        panel2b = new JPanel();
        panel2c = new JPanel();
        panel3 = new JPanel();
        

     // Dodavanje ostalih komponenti...
        panel1.setBorder(BorderFactory.createTitledBorder("Proizvodi"));
        panel1.setLayout(new GridLayout(3, 1));

        product1 = new JRadioButton("Kafa");
        product2 = new JRadioButton("Gazirani sokovi");
        product3 = new JRadioButton("Negazirani sokovi");
        productgroup = new ButtonGroup();

        productgroup.add(product1);
        productgroup.add(product2);
        productgroup.add(product3);

     // Dodavanje listenera za dugmad i liste
        product1.addActionListener(new ButtonListener());
        product2.addActionListener(new ButtonListener());
        product3.addActionListener(new ButtonListener());

        panel1.add(product1);
        panel1.add(product2);
        panel1.add(product3);

        panel2a.setLayout(new GridLayout(3, 1));
        panel2a.setPreferredSize(new Dimension(180, 650));
        panel2b.setLayout(new GridLayout(3, 1));
        panel2b.setPreferredSize(new Dimension(180, 650));
        panel2c.setLayout(new GridLayout(2, 1));
        panel2c.setPreferredSize(new Dimension(180, 650));

        subpanel1 = new JPanel();

        panel3.setLayout(new BorderLayout());

        subpanel4 = new JPanel();
        subpanel5 = new JPanel();
        subpanel5.setLayout(new BorderLayout());

        quantitylabel = new JLabel("Kolicina: ");
        quantity = new JTextField(5);
        membery = new JRadioButton("Clan");
        membern = new JRadioButton("Nije clan");
        membergroup = new ButtonGroup();
        delete = new JButton("Obrisi prethodno");

        membery.setActionCommand("Clan");
        membern.setActionCommand("Nije clan");

        delete.addActionListener(new ButtonListener());
        quantity.addActionListener(new ButtonListener());
        membern.addActionListener(new ButtonListener());
        membery.addActionListener(new ButtonListener());

        membergroup.add(membery);
        membergroup.add(membern);

        text = new JTextArea();
        scroll = new JScrollPane(text);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);

        subpanel4.add(quantitylabel);
        subpanel4.add(quantity);
        subpanel4.add(membery);
        subpanel4.add(membern);
        subpanel4.add(delete);
        subpanel5.add(scroll, BorderLayout.CENTER);

        panel3.add(subpanel4, BorderLayout.SOUTH);
        panel3.add(subpanel5, BorderLayout.CENTER);

        buttons = new JPanel();
        button1 = new JButton("Unesi");
        button2 = new JButton("Ukupno");
        button3 = new JButton("Nova porudzbina");
        buttons.setBackground(Color.black);

        button1.addActionListener(new ButtonListener());
        button2.addActionListener(new ButtonListener());
        button3.addActionListener(new ButtonListener());

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);

        subpanel1 = new JPanel();

        subpanel1.setLayout(new GridLayout());
        subpanel1.setBorder(BorderFactory.createTitledBorder("Kafe:"));

        listaKafa = new JList(kafaNiz);

        listaKafa.addListSelectionListener(new ListListener());

        subpanel1.add(listaKafa);
        panel2a.add(subpanel1);

        parent.add(panel1, BorderLayout.WEST);
        parent.add(panel2a, BorderLayout.CENTER);
        layout = (BorderLayout) parent.getLayout();

        panel2a.add(subpanel1);

        subpanel2 = new JPanel();

        subpanel2.setLayout(new GridLayout());
        subpanel2.setBorder(BorderFactory.createTitledBorder("Gazirani sokovi:"));

        listaGazirani = new JList(gaziraniNiz);

        listaGazirani.addListSelectionListener(new ListListener());

        subpanel2.add(listaGazirani);
        panel2b.add(subpanel2);

        parent.add(panel1, BorderLayout.WEST);
        parent.add(panel2b, BorderLayout.CENTER);

        subpanel3 = new JPanel();

        subpanel3.setLayout(new GridLayout());
        subpanel3.setBorder(BorderFactory.createTitledBorder("Negazirani sokovi"));

        listaNegazirani = new JList(negaziraniNiz);

        listaNegazirani.addListSelectionListener(new ListListener());

        subpanel3.add(listaNegazirani);
        panel2c.add(subpanel3);

        parent.add(panel1, BorderLayout.WEST);
        parent.add(panel2a, BorderLayout.CENTER);
        layout = (BorderLayout) parent.getLayout();

        product1.doClick();
        membern.doClick();
    }

 // Listener za dugmad u interfejsu
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	// Obrada događaja u zavisnosti od selektovanog dugmeta ili akcije
            if (product1.isSelected()) {
                parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                parent.add(panel2a, BorderLayout.CENTER);
                parent.revalidate();
                parent.repaint();
            } else if (product2.isSelected()) {
                parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                parent.add(panel2b, BorderLayout.CENTER);
                parent.revalidate();
                parent.repaint();
            } else if (product3.isSelected()) {
                parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                parent.add(panel2c, BorderLayout.CENTER);
                parent.revalidate();
                parent.repaint();
            }

            if (arg0.getActionCommand().equals("Unesi")) {
                int q = 1;

                if (!quantity.getText().isEmpty()) {
                    try {
                        q = Integer.parseInt(quantity.getText());
                    } catch (NumberFormatException e) {
                        q = 1;
                    }
                }

                StavkaNarudzbine novaStavka = null;

                if (product1.isSelected()) {
                    kafa.getSelectedButton(indeksKafa, kafaNiz);
                    kafa.Cena();
                    novaStavka = new StavkaNarudzbine(kafa.getIme(), q, kafa.getCena());
                    kafa.clear();
                } else if (product2.isSelected()) {
                    gazSok.getSelectedButton(indeksGazirani, gaziraniNiz);
                    gazSok.Cena();
                    novaStavka = new StavkaNarudzbine(gazSok.getIme(), q, gazSok.getCena());
                    gazSok.clear();
                } else if (product3.isSelected()) {
                    negSok.getSelectedButton(indeksNegazirani, negaziraniNiz);
                    negSok.Cena();
                    novaStavka = new StavkaNarudzbine(negSok.getIme(), q, negSok.getCena());
                    negSok.clear();
                }

                if (novaStavka != null) {
                    trenutnaNarudzbina.dodajStavku(novaStavka);
                }

                printOrder();
                quantity.setText("");
            } else if (arg0.getActionCommand().equals("Nova porudzbina")) {
                trenutnaNarudzbina = new Narudzbina();
                product1.doClick();
                text.setText("");
            } else if (arg0.getActionCommand().equals("Ukupno")) {
                printOrderWithQuantity();
            }

            if (arg0.getActionCommand().equals("Obrisi")) {
                int i = trenutnaNarudzbina.getStavke().size() - 1;
                trenutnaNarudzbina.getStavke().remove(i);
            } else if (arg0.getActionCommand().equals("Nije clan")) {
                isMember = false;
            } else if (arg0.getActionCommand().equals("Clan")) {
                isMember = true;
            }
        }

        // Metoda za prikaz porudžbine sa količinom
        private void printOrderWithQuantity() {
            text.setText("");
            double total = 0;
            for (StavkaNarudzbine stavka : trenutnaNarudzbina.getStavke()) {
                String naziv = stavka.getNaziv();
                int kolicina = stavka.getKolicina();
                double subtotal = stavka.getCena() * kolicina;
                total += subtotal;
                text.append(String.format("%n%40s x %d %.2f rsd", naziv, kolicina, subtotal));
            }
            text.append(String.format("%n%90s %.2f rsd", "------------------------------", total));
        }
    }

 // Listener za listu proizvoda
    private class ListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent arg0) {
            if (!arg0.getValueIsAdjusting()) {
                if (product1.isSelected()) {
                    indeksKafa = listaKafa.getSelectedIndices();
                } else if (product2.isSelected()) {
                    indeksGazirani = listaGazirani.getSelectedIndices();
                } else if (product3.isSelected()) {
                    indeksNegazirani = listaNegazirani.getSelectedIndices();
                }
            }
        }
    }

 // Metoda za prikaz porudžbine
    public void printOrder() {
        text.setText("");
        double total = 0;
        for (StavkaNarudzbine stavka : trenutnaNarudzbina.getStavke()) {
            String naziv = stavka.getNaziv();
            int kolicina = stavka.getKolicina();
            double subtotal = stavka.getCena() * kolicina;
            total += subtotal;
            text.append(String.format("%n%40s x %d %.2f rsd", naziv, kolicina, subtotal));
        }
        text.append(String.format("%n%90s %.2f rsd", "------------------------------", total));
    }

 // Glavna metoda koja pokreće aplikaciju
    public static void main(String[] args) {
        new JFrameApp();
    }
}
