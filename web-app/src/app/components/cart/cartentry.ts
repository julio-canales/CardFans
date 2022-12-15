
export class CartEntry{
    name: string;
    image: string;
    quantity: number;
    price: number;
    total: number;

    constructor(name:string, image:string, quantity:number, price:number) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.total = quantity * price;
    }
}