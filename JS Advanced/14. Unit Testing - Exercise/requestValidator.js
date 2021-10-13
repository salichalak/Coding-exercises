function solve(obj) {
    const versions = ["HTTP/0.9", "HTTP/1.0", "HTTP/1.1", "HTTP/2.0"];
    const methods = ["GET", "POST", "DELETE", "CONNECT"];
    const regexURI = /(^[\w.]+$)/;
    const regexMessage = /([<>\\&'"])/;

    if (!obj.method || obj.method === '' || !methods.includes(obj.method)) {
        throw new Error('Invalid request header: Invalid Method');
    }

    if (!obj.uri || obj.uri === '' || !regexURI.test(obj.uri)) {
        throw new Error('Invalid request header: Invalid URI');
    }

    if (!obj.version || obj.version === '' || !versions.includes(obj.version)) {
        throw new Error('Invalid request header: Invalid Version');
    }

    if (obj.message === undefined || regexMessage.test(obj.message)) {
        throw new Error('Invalid request header: Invalid Message');
    }

    return obj;
}