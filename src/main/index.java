package main;

import grafos.arista;
import grafos.camino;
import grafos.caminoDirigido;
import grafos.caminoNoDirigido;
import grafos.grafo;
import grafos.grafoDirigido;
import grafos.grafoNoDirigido;
import grafos.nodo;
import javax.swing.JOptionPane;

public class index extends javax.swing.JFrame {

    private grafo grafoNoDirigido;
    private grafo grafoDirigido;
    private final camino caminoNoDirigido;
    private final camino caminoDirigido;
    private int indice;
    private String tipoGrafoSeleccionado;
    public index() {
        indice=0;
        grafoNoDirigido = new grafoNoDirigido();
        grafoDirigido = new grafoDirigido();
        caminoNoDirigido = new caminoNoDirigido(grafoNoDirigido);
        caminoDirigido = new caminoDirigido(grafoDirigido);
        tipoGrafoSeleccionado = "";
        initComponents();
    }
    
    private String ingresandoValorNodo(){
        return JOptionPane.showInputDialog("Ingrese el valor del nodo");
    }
    
    private nodo buscarNodo(grafo grafo, String valorNodo){
        nodo resultado = null;
        try {
            int i = Integer.parseInt(valorNodo);
            resultado = grafo.getNodo(i, grafo.getNodos().size()-1);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
        return resultado;
    }
    
    private nodo obtenerNodo(grafo grafo){
        return grafo.getNodoEnLista(indice);
    }
    
    private void mostrandoInformacion(nodo aux){
        if(aux!=null){
            valorNodo.setText(String.valueOf(aux.getValor()));
            gradosNodo.setText(String.valueOf(aux.getGrados()));
            gradosEntrada.setText(aux.getDescripcionGrados(0, 1));
            gradosSalida.setText(aux.getDescripcionGrados(1, 1));
        }
    }
    
    private void agregarNodo(grafo grafo){
        int x = 0;
        int y = 0;
        int i = grafo.agregarNodo(x, y);
        JOptionPane.showMessageDialog(null, "El nuevo nodo se identifica con el "+i);
    }
    
    private void crearAristaGrafo(grafo grafo){
        nodo nodoOrigen = buscarNodo(grafo, ingresandoValorNodo());
        nodo nodoDestino = buscarNodo(grafo, ingresandoValorNodo());
        boolean resultado = grafo.crearArista(nodoOrigen, nodoDestino);
        if(resultado){
            JOptionPane.showMessageDialog(null, "Se creo la arista");
        }else{
            JOptionPane.showMessageDialog(null, "No se creo la arista");
        }
    }
    
    private void mostrarInfoGrafo(grafo grafo){
        indice = 0;
        if(grafo.getNodos().size()>1){
            avanzar.setEnabled(true);
            regresar.setEnabled(false);
        }else{
            avanzar.setEnabled(false);
            regresar.setEnabled(false);
        }
        totalGrafos.setText(String.valueOf(grafo.getTotalGrados()));
        mostrandoInformacion(obtenerNodo(grafo));
    }
    
    private void construirTrayectoriaGrafo(camino camino){
        camino.construirTrayectoria();
        if(camino.getTrayectoria().isEmpty()){
            JOptionPane.showMessageDialog(null, "No se encontro una trayectoria");
        }else{
            String trayectoria = "";
            int longitud = camino.getLongitudTrayectoria();
            for(arista arista:camino.getTrayectoria()){
                trayectoria+=arista.getNodoOrigen().getValor()+" - "+arista.getNodoDestino().getValor()+"\n";
            }
            JOptionPane.showMessageDialog(null, "La trayectoria encontrada, con una longitud de "+longitud+", es \n"+trayectoria);
        }
    }
    
    private void construirSenderoGrafo(camino camino){
        camino.construirSendero();
        if(camino.getSendero().isEmpty()){
            JOptionPane.showMessageDialog(null, "No se encontro un sendero");
        }else{
            String sendero = "";
            int longitud = camino.getLongitudSendero();
            for (arista arista : camino.getSendero()) {
                sendero+=arista.getNodoOrigen().getValor()+" - "+arista.getNodoDestino().getValor()+"\n";
            }
            JOptionPane.showMessageDialog(null, "El sendero encontrado, con una longitud de "+longitud+", es \n"+sendero);
        }
    }
    
    private void avanzar(grafo grafo){
        if(indice<grafo.getNodos().size()){
            indice++;
            totalGrafos.setText(String.valueOf(grafo.getTotalGrados()));
            mostrandoInformacion(obtenerNodo(grafo));
            
            if(indice==grafo.getNodos().size()-1){
                avanzar.setEnabled(false);
            }else{
                avanzar.setEnabled(true);
            }
            
            if(indice>0){
                regresar.setEnabled(true);
            }else{
                regresar.setEnabled(false);
            }
        }
    }
    
    private void regresar(grafo grafo){
        if(indice<grafo.getNodos().size() && indice>0){
            indice--;
            totalGrafos.setText(String.valueOf(grafo.getTotalGrados()));
            mostrandoInformacion(obtenerNodo(grafo));
            
            if(indice==0){
                regresar.setEnabled(false);
                avanzar.setEnabled(true);
            }else{
                regresar.setEnabled(true);
            }
        }else{
            avanzar.setEnabled(true);
        }
    }
    
    private void limpiarTrayectorias(camino camino){
        camino.limpiarTrayectoriasHechas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tiposGrafos = new javax.swing.ButtonGroup();
        agregarNodo = new javax.swing.JButton();
        crearArista = new javax.swing.JButton();
        construirTrayectoria = new javax.swing.JButton();
        contruirSendero = new javax.swing.JButton();
        mostrarInformacion = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        tablero = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalGrafos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        regresar = new javax.swing.JButton();
        avanzar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        valorNodo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        gradosNodo = new javax.swing.JTextField();
        gradosEntrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gradosSalida = new javax.swing.JTextField();
        dirigidoRadioButton = new javax.swing.JRadioButton();
        noDirigidoRadioButton = new javax.swing.JRadioButton();
        limpiarTrayectoriasBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        agregarNodo.setText("Agregar nodo");
        agregarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarNodoActionPerformed(evt);
            }
        });

        crearArista.setText("Crear arista");
        crearArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAristaActionPerformed(evt);
            }
        });

        construirTrayectoria.setText("Mostrar una trayectoria");
        construirTrayectoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                construirTrayectoriaActionPerformed(evt);
            }
        });

        contruirSendero.setText("Mostrar un sendero");
        contruirSendero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contruirSenderoActionPerformed(evt);
            }
        });

        mostrarInformacion.setText("Mostrar informacion");
        mostrarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarInformacionActionPerformed(evt);
            }
        });

        limpiar.setText("Limpiar todo");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        tablero.setBackground(new java.awt.Color(255, 255, 255));
        tablero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        jLabel1.setText("Total de grados en el grafo");

        totalGrafos.setEditable(false);
        totalGrafos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nodos");

        regresar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        regresar.setText("Regresar");
        regresar.setEnabled(false);
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        avanzar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        avanzar.setText("Avanzar");
        avanzar.setEnabled(false);
        avanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanzarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Valor");

        valorNodo.setEditable(false);
        valorNodo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        valorNodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Grados");

        gradosNodo.setEditable(false);
        gradosNodo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gradosNodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        gradosEntrada.setEditable(false);
        gradosEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gradosEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Grados de entrada");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Grados de salida");

        gradosSalida.setEditable(false);
        gradosSalida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gradosSalida.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tiposGrafos.add(dirigidoRadioButton);
        dirigidoRadioButton.setText("Dirigido");
        dirigidoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirigidoRadioButtonActionPerformed(evt);
            }
        });

        tiposGrafos.add(noDirigidoRadioButton);
        noDirigidoRadioButton.setText("No dirigido");
        noDirigidoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noDirigidoRadioButtonActionPerformed(evt);
            }
        });

        limpiarTrayectoriasBtn.setText("Limpiar trayectorias");
        limpiarTrayectoriasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarTrayectoriasBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(27, 27, 27)
                                        .addComponent(valorNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(27, 27, 27)
                                        .addComponent(gradosNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(88, 88, 88))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(regresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(avanzar)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gradosEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addGap(28, 28, 28))
                                    .addComponent(gradosSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalGrafos, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dirigidoRadioButton)
                    .addComponent(noDirigidoRadioButton))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(agregarNodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mostrarInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crearArista, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(construirTrayectoria, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(contruirSendero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpiarTrayectoriasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarNodo)
                    .addComponent(dirigidoRadioButton)
                    .addComponent(construirTrayectoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crearArista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(limpiarTrayectoriasBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noDirigidoRadioButton)
                    .addComponent(mostrarInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contruirSendero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalGrafos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(regresar)
                            .addComponent(avanzar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(valorNodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(gradosNodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gradosEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gradosSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableroMouseClicked
        
    }//GEN-LAST:event_tableroMouseClicked

    private void agregarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarNodoActionPerformed
        switch (tipoGrafoSeleccionado) {
            case "Dirigido":
                agregarNodo(grafoDirigido);
                break;
            case "No dirigido":
                agregarNodo(grafoNoDirigido);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Elija un tipo de grafo");
                break;
        }
    }//GEN-LAST:event_agregarNodoActionPerformed
    
    private void crearAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearAristaActionPerformed
        switch (tipoGrafoSeleccionado) {
            case "Dirigido":
                crearAristaGrafo(grafoDirigido);
                break;
            case "No dirigido":
                crearAristaGrafo(grafoNoDirigido);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Elija un tipo de grafo");
                break;
        }
    }//GEN-LAST:event_crearAristaActionPerformed
    
    private void mostrarInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarInformacionActionPerformed
        switch (tipoGrafoSeleccionado) {
            case "Dirigido":
                mostrarInfoGrafo(grafoDirigido);
                break;
            case "No dirigido":
                mostrarInfoGrafo(grafoNoDirigido);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Elija un tipo de grafo");
                break;
        }
        
    }//GEN-LAST:event_mostrarInformacionActionPerformed

    private void avanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzarActionPerformed
        switch (tipoGrafoSeleccionado) {
            case "Dirigido":
                avanzar(grafoDirigido);
                break;
            case "No dirigido":
                avanzar(grafoNoDirigido);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Elija un tipo de grafo");
                break;
        }
    }//GEN-LAST:event_avanzarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        switch (tipoGrafoSeleccionado) {
            case "Dirigido":
                regresar(grafoDirigido);
                break;
            case "No dirigido":
                regresar(grafoNoDirigido);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Elija un tipo de grafo");
                break;
        }
    }//GEN-LAST:event_regresarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        grafoDirigido = new grafoDirigido();
        grafoNoDirigido = new grafoNoDirigido();
        totalGrafos.setText("");
        tipoGrafoSeleccionado="";
        avanzar.setEnabled(false);
        regresar.setEnabled(false);
        valorNodo.setText("");
        gradosNodo.setText("");
        gradosEntrada.setText("");
        gradosSalida.setText("");
        dirigidoRadioButton.setEnabled(true);
        noDirigidoRadioButton.setEnabled(true);
        tiposGrafos.clearSelection();
    }//GEN-LAST:event_limpiarActionPerformed

    private void contruirSenderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contruirSenderoActionPerformed
        switch (tipoGrafoSeleccionado) {
            case "Dirigido":
                construirSenderoGrafo(caminoDirigido);
                break;
            case "No dirigido":
                construirSenderoGrafo(caminoNoDirigido);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Elija un tipo de grafo");
                break;
        }
    }//GEN-LAST:event_contruirSenderoActionPerformed

    private void construirTrayectoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_construirTrayectoriaActionPerformed
        switch (tipoGrafoSeleccionado) {
            case "Dirigido":
                construirTrayectoriaGrafo(caminoDirigido);
                break;
            case "No dirigido":
                construirTrayectoriaGrafo(caminoNoDirigido);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Elija un tipo de grafo");
                break;
        }
    }//GEN-LAST:event_construirTrayectoriaActionPerformed

    private void dirigidoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirigidoRadioButtonActionPerformed
        tipoGrafoSeleccionado = dirigidoRadioButton.getText();
        noDirigidoRadioButton.setEnabled(false);
    }//GEN-LAST:event_dirigidoRadioButtonActionPerformed

    private void noDirigidoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noDirigidoRadioButtonActionPerformed
        tipoGrafoSeleccionado = noDirigidoRadioButton.getText();
        dirigidoRadioButton.setEnabled(false);
    }//GEN-LAST:event_noDirigidoRadioButtonActionPerformed

    private void limpiarTrayectoriasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarTrayectoriasBtnActionPerformed
        switch (tipoGrafoSeleccionado) {
            case "Dirigido":
                limpiarTrayectorias(caminoDirigido);
                break;
            case "No dirigido":
                limpiarTrayectorias(caminoNoDirigido);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Elija un tipo de grafo");
                break;
        }
    }//GEN-LAST:event_limpiarTrayectoriasBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarNodo;
    private javax.swing.JButton avanzar;
    private javax.swing.JButton construirTrayectoria;
    private javax.swing.JButton contruirSendero;
    private javax.swing.JButton crearArista;
    private javax.swing.JRadioButton dirigidoRadioButton;
    private javax.swing.JTextField gradosEntrada;
    private javax.swing.JTextField gradosNodo;
    private javax.swing.JTextField gradosSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton limpiarTrayectoriasBtn;
    private javax.swing.JButton mostrarInformacion;
    private javax.swing.JRadioButton noDirigidoRadioButton;
    private javax.swing.JButton regresar;
    private javax.swing.JPanel tablero;
    private javax.swing.ButtonGroup tiposGrafos;
    private javax.swing.JTextField totalGrafos;
    private javax.swing.JTextField valorNodo;
    // End of variables declaration//GEN-END:variables
}
