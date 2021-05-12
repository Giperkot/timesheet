Ext.define('Timesheet.view.tab.userTimesheet.card.Controller', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.timesheet-card-controller',

    onChangeEmploye: function (_this, id, value) {
        console.log(arguments);
        let vm = this.getViewModel();

        let record = vm.getStore("employeStore").getById(id);

        if (record) {
            vm.set("item.position", record.get("position"));
        }
    },
    updateGrid: function () {
        this.getView().initialConfig.gridController.updateGrid();
    },
    saveCard: function () {
        var self = this;
        var vm = this.getViewModel();
        var item = vm.get("item");

        let method;
        let url;
        if (item.get("id") && item.get("id") > 0) {
            method = "PUT";
            url = '/api/timesheet/updateTimesheet'
        } else {
            method = "POST";
            url = '/api/timesheet/createTimesheet'
        }

        Ext.Ajax.request({
            method: method,
            url: url,
            jsonData: JSON.stringify(item.data),
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json'
            },
            success: function (response) {
                Ext.Msg.alert('Успех', 'Запись успешно сохранена!');
                self.updateGrid();
            }
        });

    },
    onActivate: function () {

    }
});
