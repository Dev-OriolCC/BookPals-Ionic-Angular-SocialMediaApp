import { User } from "./user";

export interface CustomHttpResponse<T> {
    timestamp: Date;
    statusCode: number;
    status: string;
    reason?: string;
    message?: string;
    developerMessage?: string;
    data?: T;
}

export interface UserState {
    user: User;
}