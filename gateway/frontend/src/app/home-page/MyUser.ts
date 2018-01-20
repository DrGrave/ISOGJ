import {User} from "../user-list-page/user";
import {City} from "./City";
import {Gender} from "./Gender";

export class MyUser extends User{
  city: City;
  gender: Gender;
  email: string;
  username: string;
}
