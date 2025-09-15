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

import fr.ans.psc.amar.model.CivilStatus;
import fr.ans.psc.model.AttributeEncoding;
import fr.ans.psc.model.FirstName;
import fr.ans.psc.model.Ps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class PsiCivilStatusAdapter extends CivilStatus {

    public PsiCivilStatusAdapter(Ps ps) {
        setLastName(AttributeEncoding.encodeStringAttribute(ps.getLastName()));
        setFirstNames(extractNames(ps.getFirstNames()));
        setBirthdate(convertDateToIsoFormat(ps.getDateOfBirth()));
        setBirthplace(AttributeEncoding.encodeStringAttribute(ps.getBirthAddress()));
        setBirthCountryCode(AttributeEncoding.encodeStringAttribute(ps.getBirthCountryCode()));
        setBirthTownCode(AttributeEncoding.encodeStringAttribute(ps.getBirthAddressCode()));
        setGenderCode(AttributeEncoding.encodeStringAttribute(ps.getGenderCode()));
        setPersonalCivilityTitle(AttributeEncoding.encodeStringAttribute(ps.getSalutationCode()));
    }

    private List<String> extractNames(List<FirstName> firstNames) {
    return firstNames.stream()
        .filter((FirstName f) -> f.getFirstName()!= null && !f.getFirstName().isBlank())
        .sorted(this::compareFirstNames).map(FirstName::getFirstName).collect(Collectors.toList());
    }

    private int compareFirstNames(FirstName fn1, FirstName fn2) {
        return fn1.getOrder().compareTo(fn2.getOrder());
    }

    /**
     * Convertit une date du format français (dd/MM/yyyy) vers le format ISO (yyyy-MM-dd)
     * @param frenchDate Date au format français (ex: "01/01/2000")
     * @return Date au format ISO (ex: "2000-01-01") ou null si la date est invalide
     */
    private String convertDateToIsoFormat(String frenchDate) {
        if (frenchDate == null || frenchDate.trim().isEmpty()) {
            return null;
        }
        
        try {
            DateTimeFormatter frenchFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(frenchDate, frenchFormatter);
            return date.format(isoFormatter);
        } catch (Exception e) {
            // Si la conversion échoue, retourner la date originale
            return frenchDate;
        }
    }
}
