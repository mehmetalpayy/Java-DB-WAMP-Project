/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6example;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mehmet Alpay
 */
public class Controller {
    private JTable dataTable;
    private JTextField filterTextField;
    private Dbconnector dBConnector;
    
    
    public Controller(JTable dataTable, JTextField filterTextField){
        this.dataTable = dataTable;
        this.dBConnector = new Dbconnector();
        this.filterTextField = filterTextField;
    }
    
    
    public void filterData(){
        String filter = filterTextField.getText().toUpperCase();
        List<GamesNew> gamesList = dBConnector.listgames();
        List<GamesNew> filteredList;
        
        if(filter==null || filter.equals("")){
            filteredList = gamesList;
            
        }
        else{
            filteredList = new ArrayList<>();
            for(int i = 0; i<gamesList.size(); i++){
                GamesNew temp = gamesList.get(i);
                if(temp.getName().toUpperCase().contains(filter) ||
                    temp.getGenre().toUpperCase().contains(filter) ||
                    Integer.toString(temp.getYear()).contains(filter)||
                    temp.getCompany().toUpperCase().contains(filter)) {
                    
                    filteredList.add(temp);
                }
            } 
        }
        
        
        DefaultTableModel defaultTableModel = (DefaultTableModel) dataTable.getModel();
        int rowCount = defaultTableModel.getRowCount();
        
        for(int i = rowCount-1; i>=0; i--){
            defaultTableModel.removeRow(i);
        
        }
        
        if(filteredList.isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "No data found by this filter","Error", 
                        JOptionPane.ERROR_MESSAGE);
        
        }
        
        for(int i = 0; i<filteredList.size();i++){
            
            GamesNew temp = filteredList.get(i);
            Object[] row = new Object[4];
            row[0] = temp.getName();
            row[1] = temp.getYear();
            row[2] = temp.getGenre();
            row[3] = temp.getCompany();
            defaultTableModel.addRow(row);
        }
        
    }
}
