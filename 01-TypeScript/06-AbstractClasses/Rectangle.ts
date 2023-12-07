import { Shape } from "./Shape";

export class Rectangle extends Shape {

    constructor(theX: number, theY: number, private _width: number, private _length: number) {
        super(theX, theY);
    }

    get width(): number {
        return this._width;
    }

    set width(value: number) {
        this._width = value;
    }

    get height(): number {
        return this._length;
    }

    set height(value: number) {
        this._length = value;
    }

    getInfo(): string {
        return `${super.getInfo()}, width=${this._width}, length=${this._length}`;
    }

    calculateArea(): number {
        return this._width * this._length;
    }
}