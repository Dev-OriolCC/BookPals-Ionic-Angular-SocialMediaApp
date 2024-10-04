import { Book } from "./book";
import { Genre } from "./genre";

export interface User {
    id: number;
    name: string;
    username: string;
    bio: string;
    country: string;
    birthday: Date;
    imageUrl: string;
    createdAt: Date;
    //
    books?: Book[];
    genres?: Genre[];
}