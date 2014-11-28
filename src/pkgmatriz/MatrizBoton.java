/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgmatriz;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Ignacio
 */
public class MatrizBoton extends javax.swing.JFrame {

    JButton matrizBotones[][];
    JLabel  matrizResult [][];
    final int ANCHO_BTN  = 40;
    final int ALTO_BTN   = 40;
    final int MARGEN_BTN = 5;
    final int ANCHO_RES  = 19;
    final int ALTO_RES   = 19;
    final int MARGEN_RES = 2;

    public MatrizBoton() {
        initComponents();
        actualizaPaneles();
    }
    
    private void actualizaPaneles(){
        
        //Obtenemos el Numero de Columnas y Filas
        int numCol = Integer.valueOf(jCBColumnas.getSelectedItem().toString());
        int numFil = Integer.valueOf(jCBFilas.getSelectedItem().toString());
        System.out.println("Columnas: " + numCol + " - Filas: " + numFil);
        
        //Inicializamos el Panel de los Botones
        inicializaPanelBotones(numCol, numFil);
        
        //Inicializamos el Panel del Resultado
        inicializaPanelResultado(numCol, numFil);
        
        //Inicializamos el Panel Superior
        inicializaPanelSuperior();
    }
    private void inicializaPanelBotones(int numCol, int numFil){
        //Limpiamos el Panel
        jPanelBotones.removeAll();
        
        //Cambiamos el Tamaño del Panel de Botones
        resizePanelBotones(numCol, numFil);
        
        //Añadimos los Botones al Panel de Botones
        generaBotones();
        
        //Refrescamos el Panel de Botones
        refrescaPanelBotones();
    }
    //Cambiamos el Tamaño del Panel de Botones
    private void resizePanelBotones(int numCol, int numFil){
        //Establecemos el Tamaño del Panel Botones
        int anchoPanel = (MARGEN_BTN + 2) + ((ANCHO_BTN + MARGEN_BTN) * numCol);
        int altoPanel  = (MARGEN_BTN + 2) + ((ALTO_BTN  + MARGEN_BTN) * numFil);
        System.out.println("Tamaño Panel Botones - Ancho: " + anchoPanel + " - Alto: " + altoPanel);
        jPanelBotones.setSize(anchoPanel, altoPanel);
    }
    //Actualiza Visualmente el Panel de los Botones
    private void refrescaPanelBotones(){
        //Refrescamos el Panel de los Botones
        jPanelBotones.validate();
        jPanelBotones.repaint();
    }

    private void inicializaPanelResultado(int numCol, int numFil){
        //Limpiamos el Panel
        jPanelResult.removeAll();
        
        //Reposicionamos el Panel Resultado
        posicionaPanelResultado();
        
        //Cambiamos el Tamaño del Panel Resultado
        resizePanelResultado(numCol, numFil);
        
        //Añadimos los label al Panel de Resultado
        generaLabel();
        
        //Refrescamos el Panel de Resultados
        refrescaPanelResultado();
    }
    //Reposiciona el Panel del Resultado
    private void posicionaPanelResultado(){
        int posPanResX = jPanelBotones.getX() + jPanelBotones.getWidth() + MARGEN_BTN;
        jPanelResult.setLocation(posPanResX, jPanelResult.getY());
    }
    //Cambiamos el Tamaño del Panel Resultado
    private void resizePanelResultado(int numCol, int numFil){
        int columRes = (numCol + 1) / 2;        
    
        //Establecemos el Tamaño del Panel Resultado
        int anchoPanel = (MARGEN_BTN * 2) + ((ANCHO_RES + MARGEN_RES) * columRes);
        int altoPanel  = (MARGEN_BTN + 2) + ((ALTO_BTN  + MARGEN_BTN) * numFil);
        System.out.println("Tamaño Panel Resultado - Ancho: " + anchoPanel + " - Alto: " + altoPanel);
        jPanelResult.setSize(anchoPanel, altoPanel);
    }
    //Actualiza Visualmente el Panel del Resultado
    private void refrescaPanelResultado(){
        //Refrescamos el Panel del Resultado
        jPanelResult.validate();
        jPanelResult.repaint();
    }

    private void inicializaPanelSuperior(){        
        //Cambiamos el Tamaño del Panel Superior
        resizePanelSuperior();
        
        //Refrescamos el Panel Superior
        refrescaPanelSuperior();
    }
    //Cambiamos el Tamaño del Panel Superior
    private void resizePanelSuperior(){
        
        //Establecemos el Tamaño del Panel Superior
        int anchoPanel = jPanelResult.getX() + jPanelResult.getWidth()  + MARGEN_BTN;
        int altoPanel  = jPanelResult.getY() + jPanelResult.getHeight() + MARGEN_BTN;
        System.out.println("Tamaño Panel Superior - Ancho: " + anchoPanel + " - Alto: " + altoPanel);
        jPanelSuperior.setSize(anchoPanel, altoPanel);
    }
    //Actualiza Visualmente el Panel del Resultado
    private void refrescaPanelSuperior(){
        //Refrescamos el Panel Superior
        jPanelSuperior.validate();
        jPanelSuperior.repaint();
    }    

    
    private void generaBotones(){
        
        //Obtenemos el Numero de Columnas y Filas
        int numColumnas = Integer.valueOf(jCBColumnas.getSelectedItem().toString());
        int numFilas    = Integer.valueOf(jCBFilas.getSelectedItem().toString());
        
        int posBotonesX = MARGEN_BTN + 1;
        int posBotonesY = MARGEN_BTN + 1;

        //Inicializamos las Matrices
        matrizBotones = new JButton[numFilas][numColumnas];
        
        //Generamos todos los Botones del Panel de Botones
        for (int filas = 0; filas < numFilas; filas++) {
            for (int colum = 0; colum < numColumnas; colum++) {
                //Nuevo boton
                matrizBotones[filas][colum] = new JButton();
                matrizBotones[filas][colum].setSize(ANCHO_BTN, ALTO_BTN);
                matrizBotones[filas][colum].setLocation(posBotonesX, posBotonesY);

                //Añadimos los Botones a sus Paneles
                jPanelBotones.add(matrizBotones[filas][colum]);

                //Incrementamos X
                posBotonesX = posBotonesX + ANCHO_BTN + MARGEN_BTN;
            }
            //Inicializamos Variables
            posBotonesX = MARGEN_BTN + 1;

            //Incrementamos Y
            posBotonesY = posBotonesY + ALTO_BTN + MARGEN_BTN;
        }
    }
    
    private void generaLabel(){
        
        //Obtenemos el Numero de Columnas y Filas
        int numColumnas = Integer.valueOf(jCBColumnas.getSelectedItem().toString());
        int numFilas    = Integer.valueOf(jCBFilas.getSelectedItem().toString());
        int columRes    = (numColumnas + 1) / 2;
        
        int posResultX  = MARGEN_BTN + 1;
        int posResultY  = MARGEN_BTN + 1;

        //Inicializamos las Matrices
        matrizResult  = new JLabel[numFilas][numColumnas];
        
        //Generamos todos los Label del Resultado
        for (int filas = 0; filas < numFilas; filas++) {
            for (int colum = 0; colum < numColumnas; colum++) {
                //Nuevo Label
                matrizResult [filas][colum] = new JLabel();
                matrizResult [filas][colum].setSize(ANCHO_RES, ALTO_RES);
                matrizResult [filas][colum].setLocation(posResultX , posResultY);
                matrizResult [filas][colum].setIcon(new javax.swing.ImageIcon(getClass().getResource("../Imagenes/check_verde.png")));

                //Añadimos los Botones a sus Paneles
                jPanelResult.add(matrizResult[filas][colum]);

                //Si ha llegado a la Mitad
                if ((colum + 1) == columRes) {
                    //Reposicionamos la Posicion X al Inicio
                    posResultX = MARGEN_BTN + 1;
                    
                    //Bajamos un Nivel la Posicion Y
                    posResultY = posResultY + ALTO_RES + MARGEN_RES;
                } 
                else {
                    //Aumentamos distancia en la Posicion X
                    posResultX = posResultX + ANCHO_RES + MARGEN_RES;
                }
            }
            //Reposicionamos la Posicion X al Inicio
            posResultX  = MARGEN_BTN + 1;

            //Aumentamos distancia en la Posicion Y
            posResultY  = posResultY  + ALTO_RES + MARGEN_BTN;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCBFilas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBColumnas = new javax.swing.JComboBox();
        jBGenerar = new javax.swing.JButton();
        jPanelSuperior = new javax.swing.JPanel();
        jPanelResult = new javax.swing.JPanel();
        jPanelBotones = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCBFilas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6", "7", "8", "9", "10" }));

        jLabel1.setText("Num Filas:");

        jLabel2.setText("Columnas:");

        jCBColumnas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6", "7", "8" }));

        jBGenerar.setText("Generar Botones");
        jBGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarActionPerformed(evt);
            }
        });

        jPanelResult.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelResultLayout = new javax.swing.GroupLayout(jPanelResult);
        jPanelResult.setLayout(jPanelResultLayout);
        jPanelResultLayout.setHorizontalGroup(
            jPanelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanelResultLayout.setVerticalGroup(
            jPanelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBGenerar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jCBColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGenerar))
                .addGap(18, 18, 18)
                .addComponent(jPanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarActionPerformed
        actualizaPaneles();
    }//GEN-LAST:event_jBGenerarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatrizBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrizBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrizBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrizBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatrizBoton().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGenerar;
    private javax.swing.JComboBox jCBColumnas;
    private javax.swing.JComboBox jCBFilas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelResult;
    private javax.swing.JPanel jPanelSuperior;
    // End of variables declaration//GEN-END:variables
}
