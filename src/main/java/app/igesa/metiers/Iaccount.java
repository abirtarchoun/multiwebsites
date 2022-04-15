package app.igesa.metiers;

import app.igesa.dto.AccountDTO;
import app.igesa.dto.ChangerPasswordDTO;

public interface Iaccount {
    public AccountDTO changerPassword(ChangerPasswordDTO dto);
}
