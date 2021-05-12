Ext.define('Timesheet.view.common.ImgColumn', {
    extend: 'Ext.grid.column.Column',

    requires: [
        'Ext.util.Format',
        // 'Ext.grid.cell.Number'
        'Ext.Img'
    ],

    xtype: 'imgcolumn',

    config: {
        /**
         * @cfg {String} format
         * A format string as used by {@link Ext.util.Format#number} to format values
         * for this column.
         */
        format: null,

        defaultEditor: {
            xtype: 'numberfield'
        },

        cell: {
            xtype: 'image'
        }
    }
});
