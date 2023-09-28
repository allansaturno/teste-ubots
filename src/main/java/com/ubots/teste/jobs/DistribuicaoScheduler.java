package com.ubots.teste.jobs;

import com.ubots.teste.domain.AvailableDomain;
import com.ubots.teste.domain.SolicitacaoDomain;
import com.ubots.teste.service.SolicitacaoService;
import com.ubots.teste.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistribuicaoScheduler {
    private final SolicitacaoService solicitacaoService;
    private final UsuarioService usuarioService;

    @Scheduled(cron = "*/30 * * * * *")
    void distribuir() {

        solicitacaoService.findByIdUsuarioIsNull()
                .forEach(solicitacaoDomain -> {
                    final var solic = findUserAndSetRequest(solicitacaoDomain);
                    solicitacaoService.save(solic);
                });

    }

    private SolicitacaoDomain findUserAndSetRequest(SolicitacaoDomain solicitacaoDomain) {
        final var availableUser = usuarioService.findAvailable(solicitacaoDomain.getIdGrupo())
                .stream()
                .findFirst()
                .map(AvailableDomain::getIdUsuario)
                .orElse(null);

        return solicitacaoDomain.withIdUsuario(availableUser);
    }
}
