package tramdb.ui;

import javax.swing.table.AbstractTableModel;
import tramdb.dtos.MajorDTO;
import tramdb.dtos.MajorList;

/**
 *
 * @author yiyangqianxi
 */
public class MajorModel extends AbstractTableModel {

    MajorList list;

    public MajorModel(MajorList list) {
        this.list = list;
    }

    public MajorList gerList() {
        return list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MajorDTO mar = list.get(rowIndex);
        Object obj = null;
        switch (columnIndex) {
            case 0:
                obj = mar.getMajorID();
                break;
            case 1:
                obj = mar.getMajorName();
                break;
        }
        return obj;
    }

    @Override
    public String getColumnName(int column) {
        String columnName = "";
        switch (column) {
            case 0:
                columnName = "ID";
                break;
            case 1:
                columnName = "Name";
                break;
        }
        return columnName;
        //To change body of generated methods, choose Tools | Templates.
    }
}
