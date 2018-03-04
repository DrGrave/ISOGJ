import {Company} from "./Company";
import {Position} from "./Position";

export class Experience{
  id: number;
  dateOfStart: number;
  dateOfEnd: number;
  company: Company;
  position: Position;
}
