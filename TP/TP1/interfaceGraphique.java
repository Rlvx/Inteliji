import com.sun.nio.file.ExtendedWatchEventModifier;

import javax.naming.spi.ObjectFactoryBuilder;
import javax.print.attribute.standard.JobStateReason;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class interfaceGraphique implements ActionListener, ItemListener, WindowListener {
    private Client client;
    private JScrollPane scrollBar_Principal,scrollBar_Porte;
    private ArrayList<Object> listeEquipementType ;
    private ArrayList<Equipement> porteBuffer ;
    private JFrame fenPrinciaple,fenetreAjouterEquipement,fenetreDetails,fenetreBaie,fenetrePorte ;
    private JMenuBar barreDeMenu_Principale ;
    private JMenu menuPeage;
    private JMenuItem ajouterEquipement,ajouterPorte,quitter,connexion,sauvgarder ;
    private JPanel panelPrincipal_haut,panelPrincipal_bas,panelGroupButton,panelMiseenbaieEtat,barriere_etat_panel,typeEcran_panel,porteHaut_panel,porteCenter_panel,porteSens_panel;
    private JTextField saisieIPMAC,saisirIp_field,saisirMac_field,saisirImageparsec_field,saisirResolution_field,saisirFrequence_field,saisirLongueurOnde_field,saisirPortee_field,saisirTypeCamera_field,saisirLongeur_field,saisirLargeur_field,saisirHauteur_field,saisirLongueurBarriere_field,saisirResolutionEcran_field,saisirTempsDeRep_field;
    private JRadioButton radioIP,radioMAC,miseEnBaieOui,miseEnBaieNon,etatON,etatOFF,barriere_etatOpen,barriere_etatClose,Ecran_Allume,Ecran_Eteint,sensPorte_1,sensPorte_2;
    private ButtonGroup groupIPMAC,groupOUINON,groupONOFF,barriere_etat,typeEcran_group,sensPorte_group;
    private JButton validerSaisieIPMAC,validerAjoutEquipements,validerDetails,validerDims,ajouterEquipement_button,validerPorte;
    private JTextArea affichagePeage,affichagePorte;
    private JComboBox choixEquipement;
    private JLabel saisirMac_label,saisirIp_label,selectEkip,miseEnBaie,etats,labelValidé,saisirImageparsec_label,saisirResolution_label,saisirFrequence_label,saisirLongueurOnde_label,saisirPortee_label,saisirTypeCamera_label,saisirLongeur_label,saisirLargeur_label,saisirHauteur_label,saisirLongueurBarriere_label,saisirEtat_label,saisirTypeEcran_label,saisirResolutionEcran_label,saisirTempsDeRep_label,saisirEtatPorte_label,saisirSens_label,ajouterEkipPorte_label,affichageEkipPorte_label ;
    private boolean detailsIsValidate,baieIsValidate,etatBarriere_buffer,typeEcran_buffer,open,waitRetrun,isConnect;
    private double nbImavgeSeconde_buffer,resolutionCamera_buffer,frequence_buffer,longueurOnde_buffer,porteeMaximale_buffer,largeur_buffer,longueur_buffer,hauteur_buffer,longueurBarriere_buffer,tempsDeRep_buffer;
    private String typeCamera_buffer,equipementChoisi,resolutionEcran_buffer;
    private JCheckBox etatPorte,all;

    interfaceGraphique(Client e) {
        client = new Client();
        client = e;
        fenetrePrincipale();
    }
    public ArrayList loadEquipements(){
        String ligne ;
        listeEquipementType = new ArrayList<>();
        try {
            String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TP\\TP1\\TypeEquipementPeage.csv";
            BufferedReader fichier = new BufferedReader(new FileReader(chemin));
            while ((ligne = fichier.readLine())!= null){
                listeEquipementType.add(ligne);
            }
            fichier.close();
            return listeEquipementType;
        }catch (FileNotFoundException e){
            System.out.println("Pas de fichier avec ce nom");
        }catch (IOException e){
            System.out.println("Erreur lors de la lecture");
        }
        return listeEquipementType;
    }
    public void fenetrePrincipale(){
        isConnect=false;
        fenPrinciaple = new JFrame();
        fenPrinciaple.setBounds(50,50,1240,720);
        fenPrinciaple.setTitle("Fenetre Principale");
        fenPrinciaple.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        barreDeMenu_Principale = new JMenuBar();
        menuPeage = new JMenu("Péage");
        ajouterEquipement = new JMenuItem("Ajouter Equipements");
        ajouterPorte = new JMenuItem("Ajouter Porte");
        quitter = new JMenuItem("Quitter");
        connexion = new JMenuItem("Connexion");
        panelPrincipal_haut = new JPanel();
        panelPrincipal_bas = new JPanel();
        scrollBar_Principal = new JScrollPane(panelPrincipal_bas,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        saisieIPMAC = new JTextField();
        radioIP = new JRadioButton("IP");
        radioMAC = new JRadioButton("MAC");
        validerSaisieIPMAC = new JButton("Rechercher");
        groupIPMAC = new ButtonGroup();
        affichagePeage = new JTextArea();
        all = new JCheckBox("all");
        sauvgarder = new JMenuItem("Sauvegarder");
        radioIP.setSelected(true);
        ajouterEquipement.setEnabled(false);
        ajouterPorte.setEnabled(false);
        quitter.setEnabled(false);
        sauvgarder.setEnabled(false);
        affichagePeage.setDisabledTextColor(Color.black);
        ajouterPorte.addActionListener(this::actionPerformed);
        ajouterEquipement.addActionListener(this::actionPerformed);
        quitter.addActionListener(this::actionPerformed);
        affichagePeage.setEnabled(false);
        groupIPMAC.add(radioIP);
        groupIPMAC.add(radioMAC);
        barreDeMenu_Principale.add(menuPeage);
        menuPeage.add(ajouterEquipement);
        menuPeage.add(ajouterPorte);
        menuPeage.add(quitter);
        menuPeage.add(sauvgarder);
        menuPeage.add(connexion);
        fenPrinciaple.setJMenuBar(barreDeMenu_Principale);
        panelPrincipal_bas.add(affichagePeage);
        panelPrincipal_bas.setLayout(new GridLayout(1,1));
        panelPrincipal_haut.setLayout(new GridLayout(1,5));
        panelPrincipal_haut.add(saisieIPMAC);
        panelPrincipal_haut.add(radioIP);
        panelPrincipal_haut.add(radioMAC);
        panelPrincipal_haut.add(all);
        panelPrincipal_haut.add(validerSaisieIPMAC);
        fenPrinciaple.add(panelPrincipal_haut,BorderLayout.NORTH);
        fenPrinciaple.add(scrollBar_Principal,BorderLayout.CENTER);
        validerSaisieIPMAC.addActionListener(this::actionPerformed);
        connexion.addActionListener(this::actionPerformed);
        sauvgarder.addActionListener(this::actionPerformed);
        fenPrinciaple.setVisible(true);
    }
    public void fenetreAjouterEquipement(){
        fenetreAjouterEquipement = new JFrame();
        fenetreAjouterEquipement.setBounds(100,100,800,252);
        fenetreAjouterEquipement.setTitle("Ajouter Equipement");
        fenetreAjouterEquipement.setLayout(new GridLayout(5,2));

        saisirMac_label = new JLabel("Saisir une adresse MAC : ");
        saisirIp_label = new JLabel("Saisir une adresse IP : ");
        selectEkip = new JLabel("Selectionner le type d'équipement : ");
        miseEnBaie = new JLabel("Mise en baie : ");
        etats = new JLabel("Etat : ");
        labelValidé = new JLabel("Valider l'ajout de l'équipement");
        panelGroupButton = new JPanel();
        panelMiseenbaieEtat = new JPanel();
        saisirMac_field = new JTextField();
        saisirIp_field = new JTextField();
        choixEquipement = new JComboBox();
        validerAjoutEquipements = new JButton("Valider");
        miseEnBaieNon = new JRadioButton("Non");
        miseEnBaieOui = new JRadioButton("Oui");
        groupOUINON = new ButtonGroup();
        etatOFF = new JRadioButton("Off");
        etatON = new JRadioButton("On");
        groupONOFF = new ButtonGroup();
        choixEquipement.addItem("");
        for (Object string : loadEquipements()) {
            choixEquipement.addItem(string);
        }
        groupOUINON.add(miseEnBaieOui);
        groupOUINON.add(miseEnBaieNon);
        groupONOFF.add(etatON);
        groupONOFF.add(etatOFF);
        panelGroupButton.setLayout(new GridLayout(2,2));
        panelMiseenbaieEtat.setLayout(new GridLayout(2,1));
        panelGroupButton.add(miseEnBaieOui);
        panelGroupButton.add(miseEnBaieNon);
        panelGroupButton.add(etatON);
        panelGroupButton.add(etatOFF);
        panelMiseenbaieEtat.add(miseEnBaie);
        panelMiseenbaieEtat.add(etats);

        fenetreAjouterEquipement.add(saisirMac_label);
        fenetreAjouterEquipement.add(saisirMac_field);
        fenetreAjouterEquipement.add(saisirIp_label);
        fenetreAjouterEquipement.add(saisirIp_field);
        fenetreAjouterEquipement.add(selectEkip);
        fenetreAjouterEquipement.add(choixEquipement);
        fenetreAjouterEquipement.add(panelMiseenbaieEtat);
        fenetreAjouterEquipement.add(panelGroupButton);
        fenetreAjouterEquipement.add(labelValidé);
        fenetreAjouterEquipement.add(validerAjoutEquipements);
        choixEquipement.addItemListener(this::itemStateChanged);
        validerAjoutEquipements.addActionListener(this::actionPerformed);
        miseEnBaieOui.addActionListener(this::actionPerformed);
        miseEnBaieNon.addActionListener(this::actionPerformed);
        etatOFF.setSelected(true);
        miseEnBaieNon.setSelected(true);
        fenetreAjouterEquipement.setVisible(true);
    }
    public void fenetreBaie(){
        baieIsValidate = false;
        fenetreBaie = new JFrame();
        fenetreBaie.setBounds(150,150,455,147);
        fenetreBaie.setTitle("Paramtétrage Dimension Baie");
        fenetreBaie.setLayout(new GridLayout(4,2));
        saisirLongeur_label = new JLabel("Longeur : ");
        saisirLargeur_label = new JLabel("Largeur : ");
        saisirHauteur_label = new JLabel("Heuteur : ");
        validerDims = new JButton("Valider dimensions");
        saisirLongeur_field = new JTextField();
        saisirLargeur_field = new JTextField();
        saisirHauteur_field = new JTextField();
        fenetreBaie.add(saisirLongeur_label);
        fenetreBaie.add(saisirLongeur_field);
        fenetreBaie.add(saisirLargeur_label);
        fenetreBaie.add(saisirLargeur_field);
        fenetreBaie.add(saisirHauteur_label);
        fenetreBaie.add(saisirHauteur_field);
        fenetreBaie.add(validerDims);
        fenetreBaie.addWindowListener(this);
        validerDims.addActionListener(this::actionPerformed);
        fenetreBaie.setVisible(true);

    }
    public void fenetreDetails(String type){
        open = true;
        detailsIsValidate = false;
        fenetreDetails = new JFrame();
        fenetreDetails.setBounds(150,150,455,147);
        fenetreDetails.setTitle(type);
        switch (type){
            case "Camera" :{
                fenetreDetails.setLayout(new GridLayout(4,2));
                saisirImageparsec_label = new JLabel("IPS : ");
                saisirTypeCamera_label = new JLabel("Type de caméra : ");
                saisirResolution_label = new JLabel("Résolution : ");
                validerDetails = new JButton("Valider details Camera");
                saisirImageparsec_field = new JTextField();
                saisirTypeCamera_field = new JTextField();
                saisirResolution_field = new JTextField();
                fenetreDetails.add(saisirImageparsec_label);
                fenetreDetails.add(saisirImageparsec_field);
                fenetreDetails.add(saisirTypeCamera_label);
                fenetreDetails.add(saisirTypeCamera_field);
                fenetreDetails.add(saisirResolution_label);
                fenetreDetails.add(saisirResolution_field);
                break;
            }
            case "Radar" :{
                fenetreDetails.setLayout(new GridLayout(4,2));
                saisirFrequence_label = new JLabel("Fréquence : ");
                saisirLongueurOnde_label = new JLabel("Longueur d'onde : ");
                saisirPortee_label = new JLabel("Portée maximale : ");
                validerDetails = new JButton("Valider details Radar");
                saisirFrequence_field = new JTextField();
                saisirLongueurOnde_field = new JTextField();
                saisirPortee_field = new JTextField();
                fenetreDetails.add(saisirFrequence_label);
                fenetreDetails.add(saisirFrequence_field);
                fenetreDetails.add(saisirLongueurOnde_label);
                fenetreDetails.add(saisirLongueurOnde_field);
                fenetreDetails.add(saisirPortee_label);
                fenetreDetails.add(saisirPortee_field);
                break;
            }
            case "Barrière" :{
                fenetreDetails.setLayout(new GridLayout(3,2));
                saisirLongueurBarriere_label = new JLabel("Longueur barrière : ");
                saisirEtat_label = new JLabel("Etat : ");
                validerDetails = new JButton("Valider details Barrière");
                saisirLongueurBarriere_field = new JTextField();
                barriere_etatOpen = new JRadioButton("Open");
                barriere_etatClose = new JRadioButton("Close");
                barriere_etat_panel = new JPanel();
                barriere_etat = new ButtonGroup();
                barriere_etat_panel.setLayout(new GridLayout(1,2));
                barriere_etat.add(barriere_etatOpen);
                barriere_etat.add(barriere_etatClose);
                barriere_etatClose.setSelected(true);
                barriere_etat_panel.add(barriere_etatOpen);
                barriere_etat_panel.add(barriere_etatClose);
                fenetreDetails.add(saisirLongueurBarriere_label);
                fenetreDetails.add(saisirLongueurBarriere_field);
                fenetreDetails.add(saisirEtat_label);
                fenetreDetails.add(barriere_etat_panel);
                break;
            }
            case "BornePaiement" :{
                fenetreDetails.setLayout(new GridLayout(4,2));
                saisirTypeEcran_label = new JLabel("Etat Ecran : ");
                saisirResolutionEcran_label = new JLabel("Résolution : ");
                saisirTempsDeRep_label = new JLabel("Temps de reponse : ");
                validerDetails = new JButton("Valider details Borne");
                saisirResolutionEcran_field = new JTextField();
                saisirTempsDeRep_field = new JTextField();
                Ecran_Allume = new JRadioButton("Allumé");
                Ecran_Eteint = new JRadioButton("Eteint");
                typeEcran_panel = new JPanel();
                typeEcran_group = new ButtonGroup();
                typeEcran_panel.setLayout(new GridLayout(1,2));
                typeEcran_group.add(Ecran_Allume);
                typeEcran_group.add(Ecran_Eteint);
                Ecran_Eteint.setSelected(true);
                typeEcran_panel.add(Ecran_Allume);
                typeEcran_panel.add(Ecran_Eteint);
                fenetreDetails.add(saisirTypeEcran_label);
                fenetreDetails.add(typeEcran_panel);
                fenetreDetails.add(saisirResolutionEcran_label);
                fenetreDetails.add(saisirResolutionEcran_field);
                fenetreDetails.add(saisirTempsDeRep_label);
                fenetreDetails.add(saisirTempsDeRep_field);
                break;
            }
        }

        validerDetails.addActionListener(this::actionPerformed);
        fenetreDetails.add(validerDetails);
        fenetreDetails.setVisible(true);
        fenetreDetails.addWindowListener(this);

    }
    public void fenetrePorte(){
        fenetrePorte = new JFrame();
        fenetrePorte.setBounds(100,100,800,430);
        fenetrePorte.setTitle("Ajouter une porte");
        porteHaut_panel = new JPanel();
        porteCenter_panel = new JPanel();
        porteSens_panel = new JPanel();
        saisirEtatPorte_label = new JLabel("Etat de la porte :");
        saisirSens_label = new JLabel("Sens de la porte :");
        ajouterEkipPorte_label = new JLabel("Ajouter un équipment :");
        affichageEkipPorte_label = new JLabel("Liste des équipements ajoutés :");
        etatPorte = new JCheckBox("en Service");
        sensPorte_group = new ButtonGroup();
        sensPorte_1 = new JRadioButton("Sens 1");
        sensPorte_2 = new JRadioButton("Sens 2");
        ajouterEquipement_button = new JButton("Ajouter un Equipement");
        affichagePorte = new JTextArea();
        affichagePorte.setEnabled(false);
        scrollBar_Porte = new JScrollPane(affichagePorte,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        validerPorte = new JButton("Valider Porte");
        porteBuffer = new ArrayList<>();
        affichagePorte.setDisabledTextColor(Color.black);
        affichagePorte.setText(client.voirEquipementsPorte(porteBuffer));
        porteHaut_panel.setLayout(new GridLayout(3,2));
        porteSens_panel.setLayout(new GridLayout(1,2));
        porteCenter_panel.setLayout(new GridLayout(1,2));
        sensPorte_1.setSelected(true);
        ajouterEquipement_button.addActionListener(this::actionPerformed);
        validerPorte.addActionListener(this::actionPerformed);
        sensPorte_group.add(sensPorte_1);
        sensPorte_group.add(sensPorte_2);
        porteSens_panel.add(sensPorte_1);
        porteSens_panel.add(sensPorte_2);

        porteHaut_panel.add(saisirEtatPorte_label);
        porteHaut_panel.add(etatPorte);
        porteHaut_panel.add(saisirSens_label);
        porteHaut_panel.add(porteSens_panel);
        porteHaut_panel.add(ajouterEkipPorte_label);
        porteHaut_panel.add(ajouterEquipement_button);

        porteCenter_panel.add(affichageEkipPorte_label);
        porteCenter_panel.add(scrollBar_Porte);

        fenetrePorte.add(porteHaut_panel,BorderLayout.NORTH);
        fenetrePorte.add(porteCenter_panel,BorderLayout.CENTER);
        fenetrePorte.add(validerPorte,BorderLayout.SOUTH);

        fenetrePorte.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Valider dimensions":{
                if(saisirLongeur_field.getText().isEmpty() || saisirLargeur_field.getText().isEmpty() || saisirHauteur_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci de renseigner des valeurs pour les dimensions");
                    break;
                }
                try {
                    longueur_buffer = Double.parseDouble(saisirLongeur_field.getText());
                }catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer un Double pour la longueur");
                    break;
                }
                try {
                    largeur_buffer = Double.parseDouble(saisirLargeur_field.getText());
                }catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer un Double pour la largeur");
                    break;
                }
                try {
                    hauteur_buffer = Double.parseDouble(saisirHauteur_field.getText());
                }catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer un Double pour la hauteur");
                    break;
                }
                baieIsValidate = true;
                fenetreBaie.setVisible(false);
                break;
            }
            case "Oui" :{
                fenetreBaie();
                break;
            }
            case "Non" :{
                baieIsValidate = true;
                fenetreBaie.setVisible(false);
                break;
            }
            case "Connexion" :{
                client.connexion();
                if(client.isConnexionOk()){
                    JOptionPane.showMessageDialog(new JFrame(),"Connexion au serveur effectué !");
                    quitter.setEnabled(true);
                    ajouterEquipement.setEnabled(true);
                    ajouterPorte.setEnabled(true);
                    sauvgarder.setEnabled(true);
                    affichagePeage.setText(client.voirEquipementsPeage(client.getListeEquipement(),client.getListePorte()));
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"La connexion a échoué, vérfier que le serveur est bien lancé");
                }
                break;
            }
            case "Sauvegarder" :{

                break;
            }
            case "Ajouter Equipements" :{
                fenetreAjouterEquipement();
                break;
            }
            case "Ajouter un Equipement" :{
                fenetreAjouterEquipement();
                waitRetrun = true;
                break;
            }
            case "Ajouter Porte" :{
                fenetrePorte();
                break;
            }
            case "Valider details Camera" : {
                if (saisirImageparsec_field.getText().isEmpty() || saisirTypeCamera_field.getText().isEmpty() || saisirResolution_field.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Merci d'entrer des valeurs");
                    break;
                }
                try {
                    nbImavgeSeconde_buffer = Double.parseDouble(saisirImageparsec_field.getText());
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(new JFrame(), "Merci d'entrer un Double pour l'IPS");
                    break;
                }
                try {
                    resolutionCamera_buffer = Double.parseDouble(saisirResolution_field.getText());
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(new JFrame(), "Merci d'entrer un Double pour la resolution");
                    break;
                }
                typeCamera_buffer = saisirTypeCamera_field.getText();
                detailsIsValidate = true;
                equipementChoisi = fenetreDetails.getTitle();
                fenetreDetails.setVisible(false);
                open=false;
                break;
            }
            case "Valider details Barrière" : {
                if (saisirLongueurBarriere_field.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Merci d'entrer des valeurs");
                    break;
                }
                try {
                    longueurBarriere_buffer = Double.parseDouble(saisirLongueurBarriere_field.getText());
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(new JFrame(), "Merci d'entrer un Double pour la longueur");
                    break;
                }
                etatBarriere_buffer = barriere_etatOpen.isSelected();
                detailsIsValidate = true;
                equipementChoisi = fenetreDetails.getTitle();
                fenetreDetails.setVisible(false);
                open=false;
                break;
            }
            case "Valider details Radar" :{
                if(saisirFrequence_field.getText().isEmpty() || saisirLongueurOnde_field.getText().isEmpty() || saisirPortee_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer des valeurs");
                    break;
                }
                try {
                    frequence_buffer = Double.parseDouble(saisirFrequence_field.getText());
                }catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer un Double pour la fréquence");
                    break;
                }
                try {
                    longueurOnde_buffer = Double.parseDouble(saisirLongueurOnde_field.getText());
                }catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer un Double pour la longueur d'onde");
                    break;
                }
                try {
                    porteeMaximale_buffer = Double.parseDouble(saisirPortee_field.getText());
                }catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer un Double pour la portée maximale");
                    break;
                }
                detailsIsValidate = true;
                equipementChoisi = fenetreDetails.getTitle();
                fenetreDetails.setVisible(false);
                open=false;
                break;
            }
            case "Valider details Borne" :{
                if(saisirTempsDeRep_field.getText().isEmpty() || saisirResolutionEcran_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer des valeurs");
                    break;
                }
                try {
                    tempsDeRep_buffer = Double.parseDouble(saisirTempsDeRep_field.getText());
                }catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer un Double pour le temps de réponse");
                    break;
                }
                resolutionEcran_buffer = saisirResolutionEcran_field.getText();
                typeEcran_buffer = Ecran_Allume.isSelected();
                detailsIsValidate = true;
                equipementChoisi = fenetreDetails.getTitle();
                fenetreDetails.setVisible(false);
                open=false;
                break;
            }
            case "Valider Porte" :{
                String sens = "";
                if(sensPorte_1.isSelected()){
                    sens = "Sens 1";
                }else{
                    sens = "Sens 2";
                }
                Porte une_porte = new Porte(etatPorte.isSelected(),sens) ;
                for (Equipement a : porteBuffer) {
                    une_porte.ajouterEquipement(a);
                }
                client.ajouterPorte(une_porte);
                JOptionPane.showMessageDialog(new JFrame(),"Porte bien ajouter au péage");
                fenetrePorte.setVisible(false);
                affichagePeage.setText(client.voirEquipementsPeage(client.getListeEquipement(),client.getListePorte()));
                break;
            }
            case "Valider" :{
                if(saisirIp_field.getText().isEmpty() || saisirMac_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci d'entrer une adresse MAC et une adresse IP");
                    break;
                }
                if(!detailsIsValidate){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci de valider le details de l'équipement avant de faire ça !!!");
                    break;
                }
                if(miseEnBaieOui.isSelected() && !baieIsValidate)
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Merci de valider les dimensions de la baie");
                    break;
                }
                if(waitRetrun){
                    switch (equipementChoisi){
                        case "Camera" :{
                            if(miseEnBaieOui.isSelected() && baieIsValidate){
                                double[] dims = {longueur_buffer,largeur_buffer,hauteur_buffer} ;
                                porteBuffer.add(new Camera(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),true,dims,nbImavgeSeconde_buffer,typeCamera_buffer,resolutionCamera_buffer));
                            }else{
                                porteBuffer.add(new Camera(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),false,nbImavgeSeconde_buffer,typeCamera_buffer,resolutionCamera_buffer));
                            }
                            fenetreAjouterEquipement.setVisible(false);
                            JOptionPane.showMessageDialog(new JFrame(),"Camera bien ajouter a la porte");
                            affichagePorte.setText(client.voirEquipementsPorte(porteBuffer));
                            waitRetrun=false;
                            break;
                        }
                        case "Radar" :{
                            if(miseEnBaieOui.isSelected() && baieIsValidate){
                                double[] dims = {longueur_buffer,largeur_buffer,hauteur_buffer} ;
                                porteBuffer.add(new Radar(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),true,dims,frequence_buffer,longueurOnde_buffer,porteeMaximale_buffer));
                            }else{
                                porteBuffer.add(new Radar(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),false,frequence_buffer,longueurOnde_buffer,porteeMaximale_buffer));
                            }
                            fenetreAjouterEquipement.setVisible(false);
                            JOptionPane.showMessageDialog(new JFrame(),"Radar bien ajouter a la porte");
                            affichagePorte.setText(client.voirEquipementsPorte(porteBuffer));
                            waitRetrun=false;
                            break;
                        }
                        case "Barrière" :{
                            if(miseEnBaieOui.isSelected() && baieIsValidate){
                                double[] dims = {longueur_buffer,largeur_buffer,hauteur_buffer} ;
                                porteBuffer.add(new Barrière(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),true,dims,longueurBarriere_buffer,etatBarriere_buffer));
                            }else{
                                porteBuffer.add(new Barrière(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),false,longueurBarriere_buffer,etatBarriere_buffer));
                            }
                            fenetreAjouterEquipement.setVisible(false);
                            JOptionPane.showMessageDialog(new JFrame(),"Barriere bien ajouter a la porte");
                            affichagePorte.setText(client.voirEquipementsPorte(porteBuffer));
                            waitRetrun=false;
                            break;
                        }
                        case "BornePaiement" :{
                            if(miseEnBaieOui.isSelected() && baieIsValidate){
                                double[] dims = {longueur_buffer,largeur_buffer,hauteur_buffer} ;
                                porteBuffer.add(new BornePaiement(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),true,dims,typeEcran_buffer,resolutionEcran_buffer,tempsDeRep_buffer));
                            }else{
                                porteBuffer.add(new BornePaiement(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),false,typeEcran_buffer,resolutionEcran_buffer,tempsDeRep_buffer));

                            }
                            fenetreAjouterEquipement.setVisible(false);
                            JOptionPane.showMessageDialog(new JFrame(),"Borne bien ajouter a la porte");
                            affichagePorte.setText(client.voirEquipementsPorte(porteBuffer));
                            waitRetrun=false;
                            break;
                        }
                    }
                }else{
                    switch (equipementChoisi){
                        case "Camera" :{
                            if(miseEnBaieOui.isSelected() && baieIsValidate){
                                double[] dims = {longueur_buffer,largeur_buffer,hauteur_buffer} ;
                                client.ajouterEquipement(new Camera(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),true,dims,nbImavgeSeconde_buffer,typeCamera_buffer,resolutionCamera_buffer));
                            }else{
                                client.ajouterEquipement(new Camera(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),false,nbImavgeSeconde_buffer,typeCamera_buffer,resolutionCamera_buffer));
                            }
                            fenetreAjouterEquipement.setVisible(false);
                            JOptionPane.showMessageDialog(new JFrame(),"Camera bien ajouté au Péage");
                            affichagePeage.setText(client.voirEquipementsPeage(client.getListeEquipement(),client.getListePorte()));
                            break;
                        }
                        case "Radar" :{
                            if(miseEnBaieOui.isSelected() && baieIsValidate){
                                double[] dims = {longueur_buffer,largeur_buffer,hauteur_buffer} ;
                                client.ajouterEquipement(new Radar(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),true,dims,frequence_buffer,longueurOnde_buffer,porteeMaximale_buffer));
                            }else{
                                client.ajouterEquipement(new Radar(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),false,frequence_buffer,longueurOnde_buffer,porteeMaximale_buffer));
                            }
                            fenetreAjouterEquipement.setVisible(false);
                            JOptionPane.showMessageDialog(new JFrame(),"Radar bien ajouté au Péage");
                            affichagePeage.setText(client.voirEquipementsPeage(client.getListeEquipement(),client.getListePorte()));
                            break;
                        }
                        case "Barrière" :{
                            if(miseEnBaieOui.isSelected() && baieIsValidate){
                                double[] dims = {longueur_buffer,largeur_buffer,hauteur_buffer} ;
                                client.ajouterEquipement(new Barrière(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),true,dims,longueurBarriere_buffer,etatBarriere_buffer));
                            }else{
                                client.ajouterEquipement(new Barrière(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),false,longueurBarriere_buffer,etatBarriere_buffer));
                            }
                            fenetreAjouterEquipement.setVisible(false);
                            JOptionPane.showMessageDialog(new JFrame(),"Barriere bien ajouté au Péage");
                            affichagePeage.setText(client.voirEquipementsPeage(client.getListeEquipement(),client.getListePorte()));
                            break;
                        }
                        case "BornePaiement" :{
                            if(miseEnBaieOui.isSelected() && baieIsValidate){
                                double[] dims = {longueur_buffer,largeur_buffer,hauteur_buffer} ;

                                client.ajouterEquipement(new BornePaiement(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),true,dims,typeEcran_buffer,resolutionEcran_buffer,tempsDeRep_buffer));
                            }else{
                                client.ajouterEquipement(new BornePaiement(saisirIp_field.getText(),saisirMac_field.getText(),etatON.isSelected(),false,typeEcran_buffer,resolutionEcran_buffer,tempsDeRep_buffer));

                            }
                            fenetreAjouterEquipement.setVisible(false);
                            JOptionPane.showMessageDialog(new JFrame(),"Borne bien ajouté au Péage");
                            affichagePeage.setText(client.voirEquipementsPeage(client.getListeEquipement(),client.getListePorte()));
                            break;
                        }
                    }
                }
                break;
            }
            case "Quitter" : {
                System.exit(0);
                break;
            }
            case "Rechercher" : {
                if(saisieIPMAC.getText().isEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(),"Merci de rentrer une adresse !");
                    break;
                }
                JOptionPane.showMessageDialog(new JFrame(),client.rechercherEquipement(saisieIPMAC.getText(),radioIP.isSelected(),all.isSelected()));
                break;
            }
        }

    }
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED){
            for (Object equipement : loadEquipements()) {
                if(equipement.toString().equals(e.getItem().toString())){
                    if(open){
                        fenetreDetails.setVisible(false);
                        open=false;
                    }
                    fenetreDetails(equipement.toString());
                }
            }
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(e.getSource()==fenetreDetails){
            choixEquipement.setSelectedItem("");
        }else if(e.getSource()==fenetreBaie){
            miseEnBaieNon.setSelected(true);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
