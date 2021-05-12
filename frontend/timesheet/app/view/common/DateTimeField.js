Ext.define('Timesheet.view.common.DateTimeField', {
    extend: 'Ext.Container',
    xtype: 'widget.datetimefield',

    initConfig: function (instanceConfig) {
        Ext.apply(instanceConfig, {
            items: [
                {
                    xtype: 'datefield',
                    required: Ext.isDefined(instanceConfig.required) ? instanceConfig.required : false,
                    submitValue: false,
                    flex: 1
                },
                {
                    xtype: 'timefield',
                    allowBlank: Ext.isDefined(instanceConfig.required) ? instanceConfig.required : false,
                    submitValue: false,
                    flex: 1
                }
            ]
        });

        Ext.applyIf(instanceConfig, {
            layout: {
                type: 'hbox',
                align: 'left'
            }
        });

        this.callParent(arguments);
    },

    getValue: function () {
        var dateField = this.getAt(0);
        var timeField = this.getAt(1);

        var date = dateField.getValue();
        if (date) {
            date = this.setTimePart(date, timeField.getValue());
        }

        return (date);
    },

    setValue: function (value) {
        var dateField = this.getAt(0);
        var timeField = this.getAt(1);

        if (value && Ext.isString(value)) {
            var tempValue = Imbibe.App.Date.parseDateTime(value);
            if (Ext.isDate(tempValue)) {
                value = tempValue;
            }
        }

        dateField.setValue(value);
        timeField.setValue(value);

        return (this);
    },

    getSubmitValue: function () {
        var me = this;

        return (this.serializeDateTime(me.getValue()));
    },

    parseDateTime: function (value, config) {
        if (Ext.isEmpty(value)) {
            return (value);
        } else {
            if (config && config.dateOnly) {
                return (Ext.Date.parse(value, 'Y-m-d'));
            } else {
                return (Ext.Date.parse(value, 'Y-m-d\\TH:i:sP'));
            }
        }
    },

    serializeDateTime: function (value, config) {
        if (Ext.isEmpty(value)) {
            return (value);
        } else {
            if (config && config.dateOnly) {
                return (Ext.Date.format(value, 'Y-m-d\\T00:00:00P'));
            } else {
                return (Ext.Date.format(value, 'Y-m-d\\TH:i:sP'));
            }
        }
    },

    getDatePart: function (date) {
        return (new Date(date.getFullYear(), date.getMonth(), date.getDate(), 0, 0, 0, 0));
    },

    setTimePart: function (d, t) {
        if (Ext.isEmpty(d)) {
            if (Ext.isEmpty(t)) {
                return (d);
            } else {
                d = new Date();
            }
        }
        d = this.getDatePart(d);

        if (!Ext.isEmpty(t)) {
            //Do not try to convert to a Date if time is already a date object.
            if (!Ext.isDate(t)) {
                if (t.length == 7)
                    t = '0' + t;

                t = Ext.Date.parse(t, 'h:i a');
            }

            d.setHours(t.getHours(), t.getMinutes(), 0, 0);
        }

        return (d);
    }

});
