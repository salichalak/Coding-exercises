(function stringExtension() {
    String.prototype.ensureStart = function (text) {
        if (!this.toString().startsWith(text)) {
            return text + this.toString();
        }
        return this.toString();
    };

    String.prototype.ensureEnd = function (text) {
        if (!this.toString().endsWith(text)) {
            return this.toString() + text;
        }
        return this.toString();
    };

    String.prototype.isEmpty = function () {
        return this.toString().localeCompare("") === 0;
    };

    String.prototype.truncate = function (n) {
        if (n <= 3) {
            return ".".repeat(n);
        }
        if (this.toString().length <= n) {
            return this.toString();
        } else {
            let lastIndex = this.toString().substr(0, n - 2).lastIndexOf(" ");
            if (lastIndex !== -1) {
                return this.toString().substr(0, lastIndex) + "...";
            } else {
                return this.toString().substr(0, n - 3) + "...";
            }
        }
    };

    String.format = function (string, ...params) {
        for (let i = 0; i < params.length; i++) {
            let index = string.indexOf("{" + i + "}");
            while (index !== -1) {
                string = string.replace("{" + i + "}", params[i]);
                index = string.indexOf("{" + i + "}");
            }
        }
        return string;
    }
})();