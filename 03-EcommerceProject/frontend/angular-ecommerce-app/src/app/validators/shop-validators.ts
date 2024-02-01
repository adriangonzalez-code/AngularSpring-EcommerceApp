import { FormControl, ValidationErrors } from "@angular/forms";

export class ShopValidators {

  // Whitespace validation
  static notOnlyWhitespace(control: FormControl) : ValidationErrors {

    // Check if string only contains whitespace
    if ((control.value != null) && (control.value.trim().length === 0)) {

      // Invalid, return object error
      return { 'notOnlyWhitespace': true };
    } else {
      return null;
    }
  }
}
