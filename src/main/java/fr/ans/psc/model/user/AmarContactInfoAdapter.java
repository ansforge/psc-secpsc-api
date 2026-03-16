/*
 * Copyright © 2022-2024 Agence du Numérique en Santé (ANS) (https://esante.gouv.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.ans.psc.model.user;

import fr.ans.psc.amar.v2.model.ContactInfo;
import fr.ans.psc.amar.v2.model.CivilStatus;

/**
 * Adapter qui mappe les données de contact depuis CivilStatus (modèle AMAR v2) 
 * vers ContactInfo (modèle PSI-API) pour maintenir la compatibilité
 */
public class AmarContactInfoAdapter extends ContactInfo {

    public AmarContactInfoAdapter(CivilStatus civilStatus) {
        if (civilStatus != null) {
            setEmail(civilStatus.getEmail());
            setPhone(civilStatus.getPhone());
        }
    }
}
