package com.example.rpgprofession.Profession.Event;

import java.util.UUID;

public interface ProfessionEventRepository {
    void delete(UUID uidd);
    void create(UUID uuid);
}
