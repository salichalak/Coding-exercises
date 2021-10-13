function extensibleObject() {
    let object = {
        extend: function (template) {
            for (const key of Object.keys(template)) {
                if (typeof (template[key]) === "function") {
                    Object.getPrototypeOf(object)[key] = template[key];
                } else {
                    object[key] = template[key];
                }
            }
        }
    };

    return object;
}