export class User {
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
