Ext.define('Timesheet.view.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main-controller',

    onExitUser: function () {
        Ext.Ajax.request({
            method: 'POST',
            url: '/api/user/logout',
            jsonData: JSON.stringify({
            }),
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json'
            },
            success: function (response) {
                var resp = [];
                try {
                    resp = JSON.parse(response.responseText);
                } catch (ex) {
                    console.log("Ошибка при загрузке специалистов");
                }

                window.location.href = "/login";
            }, failure: function () {
                window.location.href = "/login";
            }
        });
    }
});
