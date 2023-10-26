export class User {
    userId!: number;
    name!: string;
    email!: string;
    password!: string;
    salt!: string;
    isActive!: boolean;
    lastLogin!: string;  
}
export class LoginUser {
    email!: string;
    password!: string;
}
