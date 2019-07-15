import { CustomerAddress } from './customer-address.model';

export class Customer{
    'first-name' : string;
    'middle-name' : string;
    'last-name' : string;
    'date-of-birth' : string;
    'mobile-number' : string;
    'gender' : string;
    'customer-number' : string;
    'country-of-birth' : string;
    'country-of-residence' : string;
    'customer-segment' : string;
    'addresses' : CustomerAddress[];
}