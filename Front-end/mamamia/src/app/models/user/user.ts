export class User {
    userId!: number;
    name!: string;
    email!: string;
    password!: string;
    isActive!: boolean;
    lastLogin!: string;  
    role!: string;
}
export class LoginUser {
    email!: string;
    password!: string;
}
